package com.example.uLearn.payload.request;

import javax.validation.constraints.NotBlank;

public class ResetPasswordRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

   @NotBlank
   private String token;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
