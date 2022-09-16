package com.argentinaprograma.portfoliowebbackend.Security.Service;

import com.argentinaprograma.portfoliowebbackend.Security.Model.User;
import com.argentinaprograma.portfoliowebbackend.Security.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //Inyecciòn de depdencia (crea una instancia cuando sea requerida)
    @Autowired
    UserRepository userRepository;

 
    /* Método para buscar por nombre de usuario*/
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
    public void save( User user ){
        userRepository.save(user);
    }


}
