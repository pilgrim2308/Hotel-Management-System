package com.example.demo.service;

import com.example.demo.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
