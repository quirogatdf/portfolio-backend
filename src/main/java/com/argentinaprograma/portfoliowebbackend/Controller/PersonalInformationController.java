package com.argentinaprograma.portfoliowebbackend.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.Message;
import com.argentinaprograma.portfoliowebbackend.Dto.PersonalInformationDTO;
import com.argentinaprograma.portfoliowebbackend.Model.PersonalInformation;
import com.argentinaprograma.portfoliowebbackend.Repository.PersonalInformationRepository;
import com.argentinaprograma.portfoliowebbackend.Security.JWT.JwtProvider;
import com.argentinaprograma.portfoliowebbackend.Security.Model.User;
import com.argentinaprograma.portfoliowebbackend.Security.Repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/about")
@CrossOrigin(origins = "*")
public class PersonalInformationController {

    @Autowired
    PersonalInformationRepository personalInformationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("/view/{username}")
    @ResponseBody
    public ResponseEntity<PersonalInformation> getPersonalInformationById(@PathVariable("username") String userName) {
        Optional <User> usuario = userRepository.findByUsername(userName);
        Long user_id = usuario.get().getId();
        Optional<PersonalInformation> data = personalInformationRepository.findByUserId(user_id);
        return new ResponseEntity((data), HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<PersonalInformation> updatePersonalInformationById(@PathVariable("id")long id,  @RequestHeader(name = "Authorization") String token) {
               /* Obtener usuario del Token */
        String getUsername = jwtProvider.getUsernameFromToken(token.split(" ")[1]);

        Optional<PersonalInformation> data = personalInformationRepository.findById(id);
        /* Verifica que la información pertenezca al usuario autenticado */
        if (!data.get().getUser().getUsername().equals(getUsername)) {
            
            return new ResponseEntity(new Message("No autorizado","Error"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity((data), HttpStatus.OK);
        }
    }
    @PostMapping("/add")
    public PersonalInformation create(@RequestBody PersonalInformationDTO personalInformation) {
        return null;
    }
}
