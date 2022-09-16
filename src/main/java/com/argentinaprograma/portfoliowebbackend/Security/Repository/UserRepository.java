package com.argentinaprograma.portfoliowebbackend.Security.Repository;

import com.argentinaprograma.portfoliowebbackend.Security.Model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

}
