package com.olx.resale.app.controller;

import com.olx.resale.app.payload.LoginRequest;
import com.olx.resale.app.payload.LoginResponse;
import com.olx.resale.app.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="2. Auth Controller")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;


	@Operation(summary = "POST operation for login by user. ", description = "It is used for login by any user.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Validated @RequestBody LoginRequest loginRequest){
        log.info("Login request received for email or mobile: {}", loginRequest.getEmailOrMobileNumber());
        LoginResponse login = authService.login(loginRequest);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

  

}
