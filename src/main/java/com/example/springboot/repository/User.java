package com.example.springboot.repository;

import com.example.springboot.models.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String walletAddress;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    protected User() {
        // JPA only
    }

    public User(String name, String password, String walletAddress, String email, UserRole role) {
        this.name = name;
        this.password = password;
        this.walletAddress = walletAddress;
        this.email = email;
        this.role = role;
    }
}
