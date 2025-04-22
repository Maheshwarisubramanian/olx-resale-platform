package com.olx.resale.app.controller;

import com.olx.resale.app.entity.User;
import com.olx.resale.app.entity.enums.Role;
import com.olx.resale.app.payload.RegistrationRequest;
import com.olx.resale.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "1. User Controller")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


	@Operation(summary = "POST operation for user registration. ", description = "It is used for registration of user .")
    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@Validated @RequestBody RegistrationRequest registrationRequest,
                                         @RequestParam("role") Role role) {
        log.info("Sign-up request received for email: {}", registrationRequest.getEmail());
        try {
            userService.signUp(registrationRequest, role);
            log.info("User successfully registered with email: {}", registrationRequest.getEmail());
            return new ResponseEntity<>("User registered successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error during user registration for email: {}", registrationRequest.getEmail(), e);
            return new ResponseEntity<>("Registration failed for email or mobileNumber.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	
	@Operation(summary = "GET operation for welcome page ", description = "It is used for show the welcome page .")
    @GetMapping("/welcome")
    @PreAuthorize("hasRole('SELLER')")
    public String welcome(@RequestHeader(value = "X-Role-Guest", required = false) String guestHeader) {
        log.info("Welcome endpoint accessed.");

        if (guestHeader != null && guestHeader.equalsIgnoreCase("true")) {
            log.info("Guest user detected via header 'X-Role-Guest'.");
            return "WELCOME, GUEST USER!";
        }

        log.info("Authenticated seller accessing the welcome endpoint.");
        return "WELCOME, AUTHENTICATED SELLER!";
    }

    
	@Operation(summary = "GET operation for getting all user  ", description = "It is used to getting all user ")
	@GetMapping("/showAllUser")
	public ResponseEntity<List<User>> getAllUser() {
		log.info("Request received to fetch all users");
		List<User> users = userService.getAllUsers();
		if (users.isEmpty()) {
			log.warn("No users found");
//			throw new ProductNotFoundException("No Users found");
		}
		log.info("Successfully fetched {} user", users.size());
		return ResponseEntity.ok(users);

	}
    
    
}
