package com.example.springboothandson.service;

import com.example.springboothandson.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    void createUser(User user);

    List<User> findAll();

    void updateUser(User user);

    void deleteById(Long id);
}
