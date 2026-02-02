package com.example.springboot.controller;

import com.example.springboot.service.ProjectRegistryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRegistryService service;

    public ProjectController(ProjectRegistryService service) {
        this.service = service;
    }

    @PostMapping
    public BigInteger create(
            @RequestParam String title,
            @RequestParam String ipfsHash
    ) throws Exception {
        return service.createProject(title, ipfsHash);
    }
}