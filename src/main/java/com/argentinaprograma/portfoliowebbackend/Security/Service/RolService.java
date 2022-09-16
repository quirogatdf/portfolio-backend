package com.argentinaprograma.portfoliowebbackend.Security.Service;

import com.argentinaprograma.portfoliowebbackend.Security.Enums.RoleName;
import com.argentinaprograma.portfoliowebbackend.Security.Model.Rol;
import com.argentinaprograma.portfoliowebbackend.Security.Repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRoleName(RoleName roleName) {
        return rolRepository.findByRoleName(roleName);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}
