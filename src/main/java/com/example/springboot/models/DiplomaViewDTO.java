package com.example.springboot.models;

import lombok.Data;

@Data
public class DiplomaViewDTO {

    private Long onChainId;
    private String institution;
    private String studentName;
    private String title;
    private String publicationYear;
    private String pdfPath;

    public DiplomaViewDTO(
            Long onChainId,
            String institution,
            String studentName,
            String title,
            String publicationYear,
            String pdfPath
    ) {
        this.onChainId = onChainId;
        this.institution = institution;
        this.studentName = studentName;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pdfPath = pdfPath;
    }
}
