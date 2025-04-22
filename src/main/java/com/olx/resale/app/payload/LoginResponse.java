package com.olx.resale.app.payload;

public class LoginResponse {
    private String type;
    private String token;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse() {

    }

    public LoginResponse(String type) {
        this.type = type;
    }
}
