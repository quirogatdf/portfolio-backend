
package com.argentinaprograma.portfoliowebbackend.Service;

import com.argentinaprograma.portfoliowebbackend.Model.Skill;
import com.argentinaprograma.portfoliowebbackend.Repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    
    //Inyecciòn de depdencia (crea una instancia cuando sea requerida)
    @Autowired
    public SkillRepository skillRepository;

    /* Método para listar todas las experiencias */
    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    /* Método para listar experiencia por Id */
    public Optional<Skill> getById(Long id) {
        return skillRepository.findById(id);
    }


    /* Método para crear una experiencia */
    public void save(Skill skill) {
        skillRepository.save(skill);
    }

    /* Método para eliminar una experiencia */
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return skillRepository.existsById(id);

    }
}
