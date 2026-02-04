package com.example.springboot.service;

import com.example.springboot.repository.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User createUser(String name, String password) {
        if (repository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        User user = new User(name, password);
        return repository.save(user);
    }
}