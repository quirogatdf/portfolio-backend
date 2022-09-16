package com.argentinaprograma.portfoliowebbackend.Security.Repository;

import com.argentinaprograma.portfoliowebbackend.Security.Enums.RoleName;
import com.argentinaprograma.portfoliowebbackend.Security.Model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRoleName(RoleName roleName);

}
