package com.argentinaprograma.portfoliowebbackend.Controller;

import com.argentinaprograma.portfoliowebbackend.Dto.Message;
import com.argentinaprograma.portfoliowebbackend.Dto.ProjectDTO;
import com.argentinaprograma.portfoliowebbackend.Model.Project;
import com.argentinaprograma.portfoliowebbackend.Service.ProjectService;
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
@RequestMapping("api/v1/project")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/view")
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") Long id) {
        Optional<Project> project = projectService.getById(id);
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProjectDTO p) {
        Project newProject = new Project(p.getName(), p.getProjectDate(), p.getDescription(), p.getUrlRepository(), p.getUrlImage());
        projectService.save(newProject);
        return new ResponseEntity(new Message("Nuevo registro cargado con éxito", "200"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody ProjectDTO projectDTO) {
        if (!projectService.existsById(id)) {
            return new ResponseEntity(new Message("Not found Id.", "404"), HttpStatus.NOT_FOUND);
        }
        Project project = projectService.getById(id).get();
        project.setName(projectDTO.getName());
        project.setProjectDate(projectDTO.getProjectDate());
        project.setDescription(projectDTO.getDescription());
        project.setUrlRepository(projectDTO.getUrlRepository());
        project.setUrlImage(projectDTO.getUrlImage());
        projectService.save(project);
        return new ResponseEntity(new Message("Registro actualizado correctamente", "200"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long Id) {
        projectService.delete(Id);
        return new ResponseEntity(new Message("Registro eliminado correctamente", "200"), HttpStatus.OK);
    }
}
