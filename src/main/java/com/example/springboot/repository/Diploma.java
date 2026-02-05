package com.example.springboot.repository;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "diplomas")
public class Diploma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "on_chain_id", nullable = false, unique = true)
    private Long onChainId;

    @Column(name = "student_address", nullable = false, length = 42)
    private String studentAddress;

    @Column(name = "transaction_hash", nullable = false, length = 66)
    private String transactionHash;

    @Column(nullable = false)
    private String institution;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String publicationYear;

    @Column(name = "pdf_path", nullable = false)
    private String pdfPath;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    /* ===== Constructors ===== */

    protected Diploma() {
        // JPA only
    }

    public Diploma (
            Long onChainId,
            String transactionHash,
            String studentAddress,
            String institution,
            String title,
            String publicationYear,
            String pdfPath
    ) {
        this.onChainId = onChainId;
        this.transactionHash = transactionHash;
        this.studentAddress = studentAddress;
        this.institution = institution;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pdfPath = pdfPath;
    }

    /* ===== Getters ===== */

}
