package com.example.springboot.controller;

import com.example.springboot.service.DiplomaRegistryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    private final DiplomaRegistryService service;

    public DiplomaController(DiplomaRegistryService service) {
        this.service = service;
    }


    @PostMapping("/issue")
    public BigInteger issueDiploma(
            @RequestParam("student") String student,
            @RequestParam("institution") String institution,
            @RequestParam("file") MultipartFile pdf
    ) throws Exception {

        return service.issueDiploma(student, institution, pdf);
    }
}