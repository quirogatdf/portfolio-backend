package com.argentinaprograma.portfoliowebbackend.Service;

import com.argentinaprograma.portfoliowebbackend.Model.PersonalInformation;
import com.argentinaprograma.portfoliowebbackend.Repository.PersonalInformationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInformationService {

    //Inyecciòn de depdencia (crea una instancia cuando sea requerida)
    @Autowired
    public PersonalInformationRepository personalInformationRepository;

    /* Método para listar todos los usuarios */
    public List<PersonalInformation> listPersonalInformation() {
        return personalInformationRepository.findAll();
    }

    /* Método para listar usuario por Id */
    public PersonalInformation searchPersonalInformation(Long id) {
        return personalInformationRepository.findById(id).orElse(null);
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
