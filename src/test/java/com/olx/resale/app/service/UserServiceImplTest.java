//package com.olx.resale.app.service;
//
//import com.olx.resale.app.entity.User;
//import com.olx.resale.app.entity.enums.Role;
//import com.olx.resale.app.payload.RegistrationRequest;
//import com.olx.resale.app.payload.RegistrationResponse;
//import com.olx.resale.app.repository.UserRepository;
//import com.olx.resale.app.service.impl.UserServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@Slf4j
//@ExtendWith(MockitoExtension.class)
//public class UserServiceImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @Mock
//    private EmailService emailService;
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    private RegistrationRequest registrationRequest;
//
//    @BeforeEach
//    public void setUp() {
//        log.info("Setting up test data");
//        registrationRequest = new RegistrationRequest();
//        registrationRequest.setName("Ajay");
//        registrationRequest.setEmail("ajay@gmail.com");
//        registrationRequest.setMobileNumber("9898989898");
//        registrationRequest.setPassword("Ajay123");
//        registrationRequest.setConfirmPassword("Ajay123");
//        registrationRequest.setCity("Bengaluru");
//        registrationRequest.setState("Karnataka");
//        registrationRequest.setCountry("India");
//        registrationRequest.setPincode("560029");
//        log.info("Test data setup completed");
//    }
//
//    @Test
//    public void testSignUp() {
//        log.info("Starting testSignUp");
//        log.info("Mocking userRepository.findByEmail");
//        when(userRepository.findByEmail(registrationRequest.getEmail())).thenReturn(Optional.empty());
//        log.info("Mocking userRepository.findByMobileNumber");
//        when(userRepository.findByMobileNumber(registrationRequest.getMobileNumber())).thenReturn(Optional.empty());
//        when(passwordEncoder.encode(registrationRequest.getPassword())).thenReturn("passwordInEncodedFormat");
//
//        User savedUser = new User();
//        savedUser.setId(1L);
//        savedUser.setName(registrationRequest.getName());
//        savedUser.setEmail(registrationRequest.getEmail());
//        savedUser.setMobileNumber(registrationRequest.getMobileNumber());
//        savedUser.setPassword(registrationRequest.getPassword());
//        savedUser.setConfirmPassword(registrationRequest.getConfirmPassword());
//        savedUser.setRoles(new HashSet<>(Arrays.asList(Role.BUYER, Role.SELLER)));
//        savedUser.setCity(registrationRequest.getCity());
//        savedUser.setState(registrationRequest.getState());
//        savedUser.setCountry(registrationRequest.getCountry());
//        savedUser.setPincode(registrationRequest.getPincode());
//
//        when(userRepository.save(any(User.class))).thenReturn(savedUser);
//
//        log.info("Calling userService.signUp");
//        RegistrationResponse response = userService.signUp(registrationRequest, new HashSet<>(Arrays.asList(Role.BUYER, Role.SELLER)));
//
//        log.info("Asserting response");
//        assertNotNull(response);
//        assertEquals("Ajay", response.getName());
//        assertEquals("ajay@gmail.com", response.getEmail());
//        assertEquals("9898989898", response.getMobileNumber());
//        assertEquals("Bengaluru", response.getCity());
//        assertEquals("Karnataka", response.getState());
//        assertEquals("India", response.getCountry());
//        assertEquals("560029", response.getPincode());
//
//        verify(userRepository, times(1)).findByEmail(registrationRequest.getEmail());
//        verify(userRepository, times(1)).findByMobileNumber(registrationRequest.getMobileNumber());
//        verify(userRepository, times(1)).save(any(User.class));
//        log.info("testSignUp completed");
//    }
//}
