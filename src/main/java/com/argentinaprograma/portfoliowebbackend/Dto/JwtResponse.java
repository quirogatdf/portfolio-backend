
package com.argentinaprograma.portfoliowebbackend.Dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jwtToken;
    
}
