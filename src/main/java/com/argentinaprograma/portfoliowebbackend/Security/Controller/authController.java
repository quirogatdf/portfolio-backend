package com.argentinaprograma.portfoliowebbackend.Security.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.Message;
import com.argentinaprograma.portfoliowebbackend.Security.DTO.JwtDTO;
import com.argentinaprograma.portfoliowebbackend.Security.DTO.LoginUser;
import com.argentinaprograma.portfoliowebbackend.Security.DTO.Signup;
import com.argentinaprograma.portfoliowebbackend.Security.JWT.JwtProvider;
import com.argentinaprograma.portfoliowebbackend.Security.Service.RolService;
import com.argentinaprograma.portfoliowebbackend.Security.Service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class authController {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login (@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity(
                    new Message("Todo los campos deben ser completados"),
                    HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                loginUser.getUsername(), 
                                loginUser.getPassword()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO, HttpStatus.OK); 
    }
    
    @PostMapping("/singup")
    public ResponseEntity<?> register (@Valid @RequestBody Signup singup, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Email inválido"), HttpStatus.BAD_REQUEST);
        
            return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
    }

}
