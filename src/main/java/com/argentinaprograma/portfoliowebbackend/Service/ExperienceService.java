package com.argentinaprograma.portfoliowebbackend.Service;

import com.argentinaprograma.portfoliowebbackend.Model.Experience;
import com.argentinaprograma.portfoliowebbackend.Repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    //Inyecciòn de depdencia (crea una instancia cuando sea requerida)
    @Autowired
    public ExperienceRepository experienceRepository;

    /* Método para listar todas las experiencias */
    public List<Experience> listExperience() {
        return experienceRepository.findAll();
    }

    /* Método para listar experiencia por Id */
    public Experience searchExperience(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    /* Método para crear una experiencia */
    public void createExperience(Experience experience) {
        experienceRepository.save(experience);
    }
    
    /* Método para eliminar una experiencia */
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

}
