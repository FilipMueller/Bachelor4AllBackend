package com.example.springboot.controller;

import com.example.springboot.models.DiplomaViewDTO;
import com.example.springboot.service.DiplomaDTOService;
import com.example.springboot.service.DiplomaRegistryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/diploma")
@AllArgsConstructor
public class DiplomaController {

    private final DiplomaRegistryService service;
    private final DiplomaDTOService diplomaDTOService;

    @PostMapping("/issue")
    public BigInteger issueDiploma(
            @RequestParam("student") String student,
            @RequestParam("institution") String institution,
            @RequestParam("title") String title,
            @RequestParam("publicationYear") String publicationYear,
            @RequestParam("file") MultipartFile pdf
    ) throws Exception {

        return service.issueDiploma(student, institution, title, publicationYear, pdf);
    }

    @PostMapping("/verify")
    public boolean verifyDiploma(
            @RequestParam("onChainId") BigInteger onChainId,
            @RequestParam("file") MultipartFile pdf
    ) throws Exception {
        return service.verifyDiploma(onChainId, pdf);
    }

    @GetMapping("/all")
    public List<DiplomaViewDTO> getAllDiplomas() {
        return diplomaDTOService.getAllDiplomasForView();
    }

    @GetMapping("/student")
    public List<DiplomaViewDTO> getDiplomasForStudent(@RequestParam String name) {
        return diplomaDTOService.getDiplomasForStudent(name);
    }
}