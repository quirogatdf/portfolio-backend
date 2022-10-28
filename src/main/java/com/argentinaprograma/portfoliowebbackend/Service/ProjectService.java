/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.portfoliowebbackend.Service;

import com.argentinaprograma.portfoliowebbackend.Model.Project;
import com.argentinaprograma.portfoliowebbackend.Repository.ProjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
       //Inyecciòn de depdencia (crea una instancia cuando sea requerida)
    @Autowired
    public ProjectRepository projectRepository;

    /* Método para listar todas los proyectos */
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    /* Método para listar un Proyecto por Id */
    public Optional<Project> getById(Long id) {
        return projectRepository.findById(id);
    }


    /* Método para crear un proyecto */
    public void save(Project project) {
        projectRepository.save(project);
    }

    /* Método para eliminar un proyecto */
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
    /* Método para verificar si existe el projecto */
    public boolean existsById(Long id) {
        return projectRepository.existsById(id);

    }
    
}
