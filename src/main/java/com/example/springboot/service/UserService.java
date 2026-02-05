package com.example.springboot.service;

import com.example.springboot.models.UserRole;
import com.example.springboot.repository.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User createUser(String name, String password, String email, UserRole role) {
        if (repository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("User already exists");
        }

        ECKeyPair keyPair = null;
        try {
            keyPair = Keys.createEcKeyPair();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
        String studentAddress = "0x" + Keys.getAddress(keyPair.getPublicKey());

        User user = new User(name, password, studentAddress, email, role);
        return repository.save(user);
    }

    // ✅ GET ALL USERS
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}