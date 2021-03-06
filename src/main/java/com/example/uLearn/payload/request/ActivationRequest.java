package com.example.uLearn.payload.request;

import javax.validation.constraints.NotBlank;

public class ActivationRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
