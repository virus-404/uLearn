package com.example.uLearn.payload.request;

import javax.validation.constraints.NotBlank;

public class ActivationRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
