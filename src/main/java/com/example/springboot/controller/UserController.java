package com.example.springboot.controller;

import com.example.springboot.models.UserRole;
import com.example.springboot.repository.User;
import com.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam UserRole role
    ) {
        return service.createUser(name, password, email, role);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/auth/login")
    public UserRole login(@RequestParam String email , @RequestParam String password) {
        return service.getUserRole(email, password);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String email) {
        service.deleteUser(email);
    }
}