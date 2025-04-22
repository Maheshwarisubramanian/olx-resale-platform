package com.olx.resale.app.service;

import java.util.List;

import com.olx.resale.app.entity.User;
import com.olx.resale.app.entity.enums.Role;
import com.olx.resale.app.payload.RegistrationRequest;
import com.olx.resale.app.payload.RegistrationResponse;

public interface UserService {

	RegistrationResponse signUp(RegistrationRequest registrationRequest, Role role);

	User getUserById(long id);

	List<User> getAllUsers();
}
