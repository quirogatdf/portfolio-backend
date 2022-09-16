
package com.argentinaprograma.portfoliowebbackend.Dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtRequest implements Serializable {
    
    private static final long serialVersionUID = 696545419111167855L;
    
    private String username;
    private String password;
    
}
