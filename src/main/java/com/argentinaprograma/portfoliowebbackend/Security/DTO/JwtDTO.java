package com.argentinaprograma.portfoliowebbackend.Security.DTO;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private Long user_id;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, Long user_id, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.user_id = user_id;
        this.username = username;
        this.authorities = authorities;
    }
    
    
    
}
