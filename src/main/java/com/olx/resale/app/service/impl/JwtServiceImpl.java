package com.olx.resale.app.service.impl;

import com.olx.resale.app.entity.User;
import com.olx.resale.app.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    private static final Logger log = LoggerFactory.getLogger(JwtServiceImpl.class);
    @Value("${spring.secret-key}")
    private String secretKey;

    public SecretKey getSecretKey() {
        log.info("Generating secret key for JWT");
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateToken(User user) {
        log.info("Generating token for user with ID: {}",user.getId());
        String token= Jwts.builder()
                .subject(user.getId().toString())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .claim("roles", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(getSecretKey())
                .compact();
        log.info("Token generated successfully for user ID: {}",user.getId());
        return token;
    }

    @Override
    public Long getUserIdFromToken(String token) {
        log.info("Extracting user ID from token");
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String subject = claims.getSubject();
        log.info("User ID extracted from token: {}",subject);
        return Long.valueOf(subject);
    }
}
