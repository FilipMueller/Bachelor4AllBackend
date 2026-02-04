package com.example.springboot.controller;

import com.example.springboot.repository.User;
import com.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User createUser(
            @RequestParam String name,
            @RequestParam String password
    ) {
        return service.createUser(name, password);
    }
}