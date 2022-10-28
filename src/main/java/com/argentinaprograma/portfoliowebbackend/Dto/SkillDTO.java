package com.argentinaprograma.portfoliowebbackend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SkillDTO {
    @NotBlank
    private String skill;
    private String percent;
    private String image;

    public SkillDTO() {
    }

    public SkillDTO(String skill, String percent, String image) {
        this.skill = skill;
        this.percent = percent;
        this.image = image;
    }
    
    
    
}
