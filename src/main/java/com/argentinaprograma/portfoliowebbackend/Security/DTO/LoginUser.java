package com.argentinaprograma.portfoliowebbackend.Security.DTO;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUser {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
