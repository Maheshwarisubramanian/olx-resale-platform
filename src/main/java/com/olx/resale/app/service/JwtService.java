package com.olx.resale.app.service;

import com.olx.resale.app.entity.User;

public interface JwtService {

    String generateToken(User user);

    Long getUserIdFromToken(String token);
}
