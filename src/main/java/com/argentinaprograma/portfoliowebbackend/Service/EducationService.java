/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.portfoliowebbackend.Service;

import com.argentinaprograma.portfoliowebbackend.Model.Education;
import com.argentinaprograma.portfoliowebbackend.Repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    //Inyecciòn de depdencia (crea una instancia cuando sea requerida)
    @Autowired
    public EducationRepository educationRepository;

    /* Método para listar todas las experiencias */
    public List<Education> listEducation() {
        return educationRepository.findAll();
    }

    /* Método para listar experiencia por Id */
    public Optional<Education> getById(Long id) {
        return educationRepository.findById(id);
    }


    /* Método para crear una experiencia */
    public void save(Education education) {
        educationRepository.save(education);
    }

    /* Método para eliminar una experiencia */
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return educationRepository.existsById(id);

    }

}
