package com.olx.resale.app.service.impl;

import com.olx.resale.app.entity.User;
import com.olx.resale.app.payload.LoginRequest;
import com.olx.resale.app.payload.LoginResponse;
import com.olx.resale.app.service.AuthService;
import com.olx.resale.app.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        log.info("Login request received for email/mobile: {}", loginRequest.getEmailOrMobileNumber());

        try {
            // Authenticate user
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmailOrMobileNumber(),
                            loginRequest.getPassword()
                    )
            );

            User user = (User) authenticate.getPrincipal();
            log.info("User authenticated successfully with email/mobile: {}", loginRequest.getEmailOrMobileNumber());

            // Generate JWT token
            String token = jwtService.generateToken(user);
            log.info("JWT token generated for user with email/mobile: {}", loginRequest.getEmailOrMobileNumber());

            // Prepare response
            LoginResponse response = new LoginResponse();
            response.setType("JWT");
            response.setToken(token);

            return response;
        } catch (Exception e) {
            log.error("Login failed for email/mobile: {}", loginRequest.getEmailOrMobileNumber(), e);
            throw e;
        }
    }

}

   /* @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmailOrMobileNumber(loginRequest.getEmailOrMobileNumber(), loginRequest.getEmailOrMobileNumber())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);
        return new LoginResponse("Login successful", token);
    }
*/
    
   /* @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
        	
        	String emailOrMobileNumber = loginRequest.getEmailOrMobileNumber();
        	String password = loginRequest.getPassword();
        	
        	System.out.println("emailOrMobileNumber "+ emailOrMobileNumber);
        	System.out.println("password "+ password);
            Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		
                    loginRequest.getEmailOrMobileNumber(), 
                    loginRequest.getPassword()
                )
            );

            User user = (User) authenticate.getPrincipal();
            String token = jwtService.generateToken(user);

            LoginResponse response = new LoginResponse();
            response.setType("JWT");
            response.setToken(token);

            return response;
        } catch (LockedException e) {
            // Handle the locked account scenario
            throw new RuntimeException("User account is locked. Please contact support.");
        } catch (Exception e) {
            // Handle other authentication exceptions
            throw new RuntimeException("Authentication failed. Please check your credentials.");
        }
    }
*/

