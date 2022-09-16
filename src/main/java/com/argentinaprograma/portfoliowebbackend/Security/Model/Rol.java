package com.argentinaprograma.portfoliowebbackend.Security.Model;

import com.argentinaprograma.portfoliowebbackend.Security.Enums.RoleName;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoleName roleName;

    public Rol() {

    }

    public Rol(RoleName roleName) {
        this.roleName = roleName;
    }

}
