package com.example.springboot.service;

import com.example.springboot.models.DiplomaViewDTO;
import com.example.springboot.repository.Diploma;
import com.example.springboot.repository.DiplomaRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.repository.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiplomaDTOService {

    private final DiplomaRepository diplomaRepository;
    private final UserRepository userRepository;

    public List<DiplomaViewDTO> getAllDiplomasForView() {
        List<Diploma> diplomas = diplomaRepository.findAll();

        return diplomas.stream().map(diploma -> {
            User student = userRepository
                    .findByWalletAddress(diploma.getStudentAddress())
                    .orElseThrow(() ->
                            new IllegalStateException(
                                    "No user for wallet " + diploma.getStudentAddress()
                            )
                    );

            return new DiplomaViewDTO(
                    diploma.getOnChainId(),
                    diploma.getInstitution(),
                    student.getName(),
                    "",
                    "",
                    diploma.getPdfPath()
            );
        }).toList();
    }

    public List<DiplomaViewDTO> getDiplomasForStudent(String studentName) {

        // 1) Resolve user → wallet address
        User student = userRepository.findByName(studentName)
                .orElseThrow(() ->
                        new IllegalStateException("User not found: " + studentName)
                );

        String walletAddress = student.getWalletAddress();

        // 2) Fetch diplomas by student address
        List<Diploma> diplomas =
                diplomaRepository.findAllByStudentAddress(walletAddress);

        // 3) Map to DTOs
        return diplomas.stream()
                .map(d -> new DiplomaViewDTO(
                        d.getOnChainId(),
                        d.getInstitution(),
                        student.getName(),
                        d.getTitle(),
                        d.getPublicationYear(),
                        d.getPdfPath()
                ))
                .toList();
    }
}
