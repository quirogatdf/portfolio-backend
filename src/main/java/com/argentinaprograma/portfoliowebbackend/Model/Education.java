package com.argentinaprograma.portfoliowebbackend.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
@Entity
public class Education implements Serializable {

    private static final long serialVersionUID = 6723875715700168639L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String institution;
    @Column(name = "image_institution")
    private String imageInstitution;
    @NotBlank
    private String degree;
    @NotBlank
    @Column(name = "start_year")
    private String startYear;
    @Column(name = "end_year")
    private String endYear;   
    
    public Education(){}

    public Education(@NotBlank String institution, String imageInstitution,@NotBlank String degree,@NotBlank String startYear, String endYear) {
        this.institution = institution;
        this.imageInstitution = imageInstitution;
        this.degree = degree;
        this.startYear = startYear;
        this.endYear = endYear;
    }

 
    
}
