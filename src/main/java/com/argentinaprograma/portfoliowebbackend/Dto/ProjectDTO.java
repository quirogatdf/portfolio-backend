package com.argentinaprograma.portfoliowebbackend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ProjectDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String projectDate;
    private String description;
    @NotBlank
    private String urlRepository;
    private String urlImage;

    public ProjectDTO() {
    }

    public ProjectDTO(String name, String projectDate, String description, String urlRepository, String urlImage) {
        this.name = name;
        this.projectDate = projectDate;
        this.description = description;
        this.urlRepository = urlRepository;
        this.urlImage = urlImage;
    }
    
    
}
