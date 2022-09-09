package com.argentinaprograma.portfoliowebbackend.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.ExperienceDTO;
import com.argentinaprograma.portfoliowebbackend.Model.Experience;
import com.argentinaprograma.portfoliowebbackend.Service.ExperienceService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/experience")
@CrossOrigin(origins = "*")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("")
    public List<Experience> listExperience() {
        return experienceService.listExperience();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") Long id) {
        Experience exp = experienceService.searchExperience(id);
        return new ResponseEntity(exp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDTO experience) {
        Experience newExperience = new Experience(experience.getCompany(), experience.getImage(), experience.getPosition(), experience.getStartDate(), experience.getEndDate(), experience.getDescripcion());
        experienceService.createExperience(newExperience);
        return new ResponseEntity("Item cread", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long Id) {
        experienceService.deleteExperience(Id);
        return new ResponseEntity("Item cread", HttpStatus.OK);
    }
}
