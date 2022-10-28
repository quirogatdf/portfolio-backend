package com.argentinaprograma.portfoliowebbackend.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.Message;
import com.argentinaprograma.portfoliowebbackend.Dto.SkillDTO;
import com.argentinaprograma.portfoliowebbackend.Model.Skill;
import com.argentinaprograma.portfoliowebbackend.Service.SkillService;
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
@RequestMapping("api/v1/skill")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/view")
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") Long id) {
        Optional<Skill> skill = skillService.getById(id);
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDTO s) {
        Skill newSkill = new Skill(s.getSkill(), s.getPercent(), s.getImageSkill());
        skillService.save(newSkill);
        return new ResponseEntity(new Message("Nuevo registro cargado con éxito", "200"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody SkillDTO skillDTO) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Message("Not found Id.", "404"), HttpStatus.NOT_FOUND);
        }
        Skill skill = skillService.getById(id).get();
        skill.setSkill(skillDTO.getSkill());
        skill.setPercent(skillDTO.getPercent());
        skill.setImageSkill(skillDTO.getImageSkill());
        skillService.save(skill);
        return new ResponseEntity(new Message("Registro actualizado correctamente", "200"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long Id) {
        skillService.delete(Id);
        return new ResponseEntity(new Message("Registro eliminado correctamente", "200"), HttpStatus.OK);
    }
}
