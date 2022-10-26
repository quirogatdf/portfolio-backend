package com.argentinaprograma.portfoliowebbackend.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.EducationDTO;
import com.argentinaprograma.portfoliowebbackend.Dto.Message;
import com.argentinaprograma.portfoliowebbackend.Model.Education;
import com.argentinaprograma.portfoliowebbackend.Service.EducationService;
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
@RequestMapping("api/v1/education")
@CrossOrigin(origins = "*")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping("/view")
    public List<Education> listEducation() {
        return educationService.listEducation();
    }
    
    @GetMapping("/view/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") Long id) {
        Optional<Education> education = educationService.getById(id);
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDTO e) {
        Education newEducation = new Education(e.getInstitution(), e.getImageInstitution(), e.getDegree(), e.getStartYear(), e.getEndYear());
        educationService.save(newEducation);
        return new ResponseEntity(new Message("Nuevo registro cargado con éxito", "200"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody EducationDTO educationDTO) {
        if(!educationService.existsById(id)){
            return new ResponseEntity(new Message("Not found Id.","404"), HttpStatus.NOT_FOUND);
        }
        Education education = educationService.getById(id).get();
        education.setInstitution(educationDTO.getInstitution());
        education.setImageInstitution(educationDTO.getImageInstitution());
        education.setDegree(educationDTO.getDegree());
        education.setStartYear(educationDTO.getStartYear());
        education.setEndYear(educationDTO.getEndYear());
        educationService.save(education);
        return new ResponseEntity(new Message("Registro actualizado correctamente", "200"), HttpStatus.OK);
        
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long Id) {
        educationService.deleteEducation(Id);
        return new ResponseEntity(new Message("Registro eliminado correctamente","200"), HttpStatus.OK);
    }
    
}
