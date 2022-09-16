package com.argentinaprograma.portfoliowebbackend.Security.DTO;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Signup {

    @NotNull
    private String username;
    @NotNull
    private String password;
    private Set<String> roles = new HashSet<>();

}
