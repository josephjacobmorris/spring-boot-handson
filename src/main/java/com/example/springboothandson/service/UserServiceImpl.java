package com.example.springboothandson.service;

import com.example.springboothandson.domain.User;
import com.example.springboothandson.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>((int) users.spliterator().estimateSize());
        for (User user : users) {
            userList.add(user);
        }

        return userList;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
