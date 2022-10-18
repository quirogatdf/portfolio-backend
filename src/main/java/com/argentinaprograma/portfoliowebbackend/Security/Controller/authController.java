package com.argentinaprograma.portfoliowebbackend.Security.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.Message;
import com.argentinaprograma.portfoliowebbackend.Security.DTO.JwtDTO;
import com.argentinaprograma.portfoliowebbackend.Security.DTO.LoginUser;
import com.argentinaprograma.portfoliowebbackend.Security.DTO.Signup;
import com.argentinaprograma.portfoliowebbackend.Security.Enums.RoleName;
import com.argentinaprograma.portfoliowebbackend.Security.JWT.JwtProvider;
import com.argentinaprograma.portfoliowebbackend.Security.Model.Rol;
import com.argentinaprograma.portfoliowebbackend.Security.Model.User;
import com.argentinaprograma.portfoliowebbackend.Security.Repository.UserRepository;
import com.argentinaprograma.portfoliowebbackend.Security.Service.RolService;
import com.argentinaprograma.portfoliowebbackend.Security.Service.UserDetailsServiceImpl;
import com.argentinaprograma.portfoliowebbackend.Security.Service.UserService;
import com.argentinaprograma.portfoliowebbackend.Util.ResponseHandler;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) throws Exception {
        /* Verifica que el nombre de los campos, sean los correctos */
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(
                    new Message("The entered attributes are not valid.", "Error"),
                    HttpStatus.BAD_REQUEST);
        }
        /* Verifica que se haya ingresado el usuario y la contraseña */
        if (loginUser.getUsername().isEmpty() || loginUser.getPassword().isEmpty()) {
            return new ResponseEntity(
                    new Message("All fields are required.", "Error"), HttpStatus.BAD_REQUEST);
        }
        /* Valida los datos del usuario exista en la Base de Datos */
        if (!userService.existsByUsername(loginUser.getUsername())) {
            return new ResponseEntity(
                    new Message("Username does not exist.", "Error"), HttpStatus.BAD_REQUEST);
        }
        try {
          
            Authentication authentication = 
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
            ));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            //UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginUser.getUsername());
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            /* Obtener el Id */
            Optional<User> userData = userRepository.findByUsername(userDetails.getUsername());
            Long user_id = userData.get().getId();
            JwtDTO jwtDTO = new JwtDTO(jwt, user_id, userDetails.getUsername(), userDetails.getAuthorities());
            return new ResponseEntity(jwtDTO, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity(new Message("Incorrect password.", "Error"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/singup")
    public ResponseEntity<?> register(@Valid @RequestBody Signup newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseHandler.generateResponse("Username inválido", HttpStatus.BAD_REQUEST,null);
        }
        if (userService.existsByUsername(newUser.getUsername())) {
            return ResponseHandler.generateResponse("This username is already in use", HttpStatus.BAD_REQUEST,null);
        }
        User user = new User(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()));
        System.out.println(passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRoleName(RoleName.ROLE_USER).get());
        user.setRoles(roles);
        userService.save(user);
        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, user);
    }

}
