package com.argentinaprograma.portfoliowebbackend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class EducationDTO {
    @NotBlank
    private String institution;
    private String imageInstitution;
    @NotBlank
    private String degree;
    @NotBlank
    private String startYear;
    private String endYear;  

    public EducationDTO() {
    }

    public EducationDTO(String institution, String imageInstitution, String degree, String startYear, String endYear) {
        this.institution = institution;
        this.imageInstitution = imageInstitution;
        this.degree = degree;
        this.startYear = startYear;
        this.endYear = endYear;
    }
    
    
    
}
