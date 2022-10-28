
package com.argentinaprograma.portfoliowebbackend.Model;

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
    private String image;

    public Skill() {
    }

    public Skill(String skill,String percent, String image) {
        this.skill = skill;
        this.percent = percent;
        this.image = image;
    }
     
}
