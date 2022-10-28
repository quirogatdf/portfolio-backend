
package com.argentinaprograma.portfoliowebbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String skill;
    private String percent;
    @Column(name="image_skill")
    private String imageSkill;

    public Skill() {
    }

    public Skill(String skill,String percent, String imageSkill) {
        this.skill = skill;
        this.percent = percent;
        this.imageSkill = imageSkill;
    }
     
}
