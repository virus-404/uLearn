package com.example.uLearn.service;

import com.example.uLearn.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
