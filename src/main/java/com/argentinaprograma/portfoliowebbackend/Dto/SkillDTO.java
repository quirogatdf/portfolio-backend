package com.argentinaprograma.portfoliowebbackend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class SkillDTO {
    @NotBlank
    private String skill;
    private String percent;
    private String imageSkill;

    public SkillDTO() {
    }

    public SkillDTO(String skill, String percent, String imageSkill) {
        this.skill = skill;
        this.percent = percent;
        this.imageSkill = imageSkill;
    }
    
    
    
}
