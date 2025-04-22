package com.olx.resale.app.service;

import com.olx.resale.app.payload.LoginRequest;
import com.olx.resale.app.payload.LoginResponse;

public interface AuthService {

   LoginResponse login(LoginRequest loginRequest);

}
