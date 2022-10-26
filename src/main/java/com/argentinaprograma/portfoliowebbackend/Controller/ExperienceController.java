package com.argentinaprograma.portfoliowebbackend.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.ExperienceDTO;
import com.argentinaprograma.portfoliowebbackend.Dto.Message;
import com.argentinaprograma.portfoliowebbackend.Model.Experience;
import com.argentinaprograma.portfoliowebbackend.Service.ExperienceService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/experience")
@CrossOrigin(origins = "*")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/view")
    public List<Experience> listExperience() {
        return experienceService.listExperience();
    }
    
    @GetMapping("/view/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") Long id) {
        Optional<Experience> experience = experienceService.getById(id);
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDTO experience) {
        Experience newExperience = new Experience(experience.getImage(), experience.getCompany(), experience.getPosition(), experience.getStartDate(), experience.getEndDate(), experience.getDescripcion());
        experienceService.save(newExperience);
        return new ResponseEntity(new Message("Registro cargado con éxito", "200"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody ExperienceDTO experienceDTO) {
        if(!experienceService.existsById(id)){
            return new ResponseEntity(new Message("no existe","404"), HttpStatus.NOT_FOUND);
        }
        Experience experience = experienceService.getById(id).get();
        experience.setCompany(experienceDTO.getCompany());
        experience.setPosition(experienceDTO.getPosition());
        experience.setStartDate(experienceDTO.getStartDate());
        experience.setEndDate(experienceDTO.getEndDate());
        experience.setImage(experienceDTO.getImage());
        experience.setDescripcion(experienceDTO.getDescripcion());
        experienceService.save(experience);
        return new ResponseEntity(new Message("Producto actualizado", "200"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long Id) {
        experienceService.deleteExperience(Id);
        return new ResponseEntity(new Message("Eliminado correctamente","200"), HttpStatus.OK);
    }
}
