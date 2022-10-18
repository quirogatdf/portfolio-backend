package com.argentinaprograma.portfoliowebbackend.Service;

import com.argentinaprograma.portfoliowebbackend.Model.PersonalInformation;
import com.argentinaprograma.portfoliowebbackend.Repository.PersonalInformationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalInformationService {

    //Inyecciòn de depedencia (crea una instancia cuando sea requerida)
    @Autowired
    public PersonalInformationRepository personalInformationRepository;

    /* Método para listar usuario por Id */
    public Optional<PersonalInformation>getOne(Long id) {
        return personalInformationRepository.findById(id);
    }

    /* Método para crear un usuario */
    public void createPersonalInformation(PersonalInformation personalInformation) {
        personalInformationRepository.save(personalInformation);
    }

    /* Método para eliminar un usuario */
    public void deletePersonalInformation(Long id) {
        personalInformationRepository.deleteById(id);
    }
}
