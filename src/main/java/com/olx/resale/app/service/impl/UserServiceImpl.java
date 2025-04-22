package com.olx.resale.app.service.impl;

import com.olx.resale.app.controller.AuthController;
import com.olx.resale.app.entity.User;
import com.olx.resale.app.entity.enums.Role;
import com.olx.resale.app.exception.UserAlreadyExistsException;
import com.olx.resale.app.payload.RegistrationRequest;
import com.olx.resale.app.payload.RegistrationResponse;
import com.olx.resale.app.repository.UserRepository;
import com.olx.resale.app.service.EmailService;
import com.olx.resale.app.service.UserService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailOrMobileNumber(username, username).orElseThrow(() -> new BadCredentialsException("User not found with emailOrMobile: " + username));
    }

    @Override
    public RegistrationResponse signUp(RegistrationRequest registrationRequest, Role role) {

        if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
            log.error("Email is already present {}", registrationRequest.getEmail());
            throw new UserAlreadyExistsException("Email already exists");
        }

        if (userRepository.findByMobileNumber(registrationRequest.getMobileNumber()).isPresent()) {
            log.error("Mobile Number is already present {}", registrationRequest.getMobileNumber());
            throw new UserAlreadyExistsException("Mobile Number already exists");
        }

        if (!registrationRequest.getPassword().equals(registrationRequest.getConfirmPassword())) {
            log.error("Password is not matching {}{}", registrationRequest.getPassword(), registrationRequest.getConfirmPassword());
            throw new UserAlreadyExistsException("Password & Confirm password is not matching");
        }

        User user = new User();
        user.setName(registrationRequest.getName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(registrationRequest.getConfirmPassword()));
        user.setRole(role);
        user.setMobileNumber(registrationRequest.getMobileNumber());
        user.setCity(registrationRequest.getCity());
        user.setState(registrationRequest.getState());
        user.setPincode(registrationRequest.getPincode());
        user.setCountry(registrationRequest.getCountry());
        User savedUser = userRepository.save(user);
        log.info("Registration details saved {}", savedUser);
        sendRegistrationMail(savedUser);

        RegistrationResponse response = new RegistrationResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setMobileNumber(savedUser.getMobileNumber());
        response.setCity(savedUser.getCity());
        response.setState(savedUser.getState());
        response.setPincode(savedUser.getPincode());
        response.setCountry(savedUser.getCountry());
        return response;
    }

    @Override
    public User getUserById(long id) {
        log.info("Fetch the user by id {}", id);
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not found"));
    }



    @Async
    public void sendRegistrationMail(User user) {
        log.info("Preparing to send registration email to: "+user.getEmail());
        String emailContent = "<html>" +
                "<body>" +
                "<h1>Welcome to OLX Resale App!</h1>" +
                "<p>Dear " + user.getName() + ",</p>" +
                "<p>Thank you for registering with OLX Resale App. We are excited to have you on board.</p>" +
                "<p>Here are your registration details:</p>" +
                "<ul>" +
                "<li><strong>Name:</strong> " + user.getName() + "</li>" +
                "<li><strong>Email:</strong> " + user.getEmail() + "</li>" +
                "<li><strong>Mobile Number:</strong> " + user.getMobileNumber() + "</li>" +
                "<li><strong>City:</strong> " + user.getCity() + "</li>" +
                "<li><strong>State:</strong> " + user.getState() + "</li>" +
                "<li><strong>Country:</strong> " + user.getCountry() + "</li>" +
                "</ul>" +
                "<p>If you have any questions or need assistance, feel free to contact our support team.</p>" +
                "<p>Best regards,<br/>The OLX Resale App Team</p>" +
                "</body>" +
                "</html>";
        log.info("Email content generated for user: "+user.getName());
        log.info("Sending registration email to: "+user.getEmail());
        emailService.sendMail(user.getEmail(), "Thank You for Registering", emailContent);
        log.info("Registration email successfully sent to : "+user.getEmail());
    }

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> user = userRepository.findAll();
		return user;
	}


   /* @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailOrMobileNumber(username, username).orElseThrow(() -> new BadCredentialsException("User not found with emailOrMobile: " + username));
    }

    @Override
    public RegistrationResponse signUp(RegistrationRequest registrationRequest, Role role) {

        if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        if (userRepository.findByMobileNumber(registrationRequest.getMobileNumber()).isPresent()) {
            throw new UserAlreadyExistsException("Mobile Number already exists");
        }

        if (!registrationRequest.getPassword().equals(registrationRequest.getConfirmPassword())) {
            throw new UserAlreadyExistsException("Password is not matching");
        }

        User user = new User();
        user.setName(registrationRequest.getName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(registrationRequest.getConfirmPassword()));
        user.setRole(role);
        user.setMobileNumber(registrationRequest.getMobileNumber());
        user.setCity(registrationRequest.getCity());
        user.setState(registrationRequest.getState());
        user.setPincode(registrationRequest.getPincode());
        user.setCountry(registrationRequest.getCountry());
        User savedUser = userRepository.save(user);
        sendRegistrationMail(savedUser);

        RegistrationResponse response = new RegistrationResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setMobileNumber(savedUser.getMobileNumber());
        response.setCity(savedUser.getCity());
        response.setState(savedUser.getState());
        response.setPincode(savedUser.getPincode());
        response.setCountry(savedUser.getCountry());
        return response;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not found"));
    }

    @Async
    public void sendRegistrationMail(User user) {
        String emailContent = "<html>" +
                "<body>" +
                "<h1>Welcome to OLX Resale App!</h1>" +
                "<p>Dear " + user.getName() + ",</p>" +
                "<p>Thank you for registering with OLX Resale App. We are excited to have you on board.</p>" +
                "<p>Here are your registration details:</p>" +
                "<ul>" +
                "<li><strong>Name:</strong> " + user.getName() + "</li>" +
                "<li><strong>Email:</strong> " + user.getEmail() + "</li>" +
                "<li><strong>Mobile Number:</strong> " + user.getMobileNumber() + "</li>" +
                "<li><strong>City:</strong> " + user.getCity() + "</li>" +
                "<li><strong>State:</strong> " + user.getState() + "</li>" +
                "<li><strong>Country:</strong> " + user.getCountry() + "</li>" +
                "</ul>" +
                "<p>If you have any questions or need assistance, feel free to contact our support team.</p>" +
                "<p>Best regards,<br/>The OLX Resale App Team</p>" +
                "</body>" +
                "</html>";
        emailService.sendMail(user.getEmail(), "Thank You for Registering", emailContent);
    }*/

}
