package com.argentinaprograma.portfoliowebbackend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienceDTO {
    @NotBlank
    private String image;
    @NotBlank
    private String company;
    @NotBlank
    private String position;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;
    @NotBlank
    private String descripcion;

    public ExperienceDTO() {

    }

    public ExperienceDTO(@NotBlank String image,@NotBlank String company,@NotBlank String position,@NotBlank String startDate,@NotBlank String endDate,@NotBlank String descripcion) {
        this.image = image;
        this.company = company;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.descripcion = descripcion;
    }

}
