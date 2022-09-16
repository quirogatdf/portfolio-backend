package com.argentinaprograma.portfoliowebbackend.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.PersonalInformationDTO;
import com.argentinaprograma.portfoliowebbackend.Model.PersonalInformation;
import com.argentinaprograma.portfoliowebbackend.Repository.PersonalInformationRepository;
import com.argentinaprograma.portfoliowebbackend.Service.PersonalInformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/personal-information")
@CrossOrigin(origins = "*")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;
    //private final PersonalInformationRepository personalInformationRepository;
    //public PerfilInformationController( PersonalInformationReposi)

    @GetMapping("")
    public List<PersonalInformation> listPersonalInformation() {
        return personalInformationService.listPersonalInformation();
    }
    @PostMapping("/add")
    public PersonalInformation create (@RequestBody PersonalInformationDTO personalInformation){
        return null;
    }
}
