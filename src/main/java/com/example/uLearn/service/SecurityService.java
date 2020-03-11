package com.example.uLearn.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
