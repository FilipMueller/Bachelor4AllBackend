package com.example.springboot.models;

import lombok.Data;

@Data
public class DiplomaViewDTO {

    private Long onChainId;
    private String institution;
    private String studentName;
    private String title;
    private String publicationYear;
    private Boolean revoked;
    private String pdfPath;

    public DiplomaViewDTO(
            Long onChainId,
            String institution,
            String studentName,
            String title,
            String publicationYear,
            Boolean revoked,
            String pdfPath
    ) {
        this.onChainId = onChainId;
        this.institution = institution;
        this.studentName = studentName;
        this.title = title;
        this.publicationYear = publicationYear;
        this.revoked = revoked;
        this.pdfPath = pdfPath;
    }
}
