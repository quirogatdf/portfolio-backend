package com.argentinaprograma.portfoliowebbackend.Repository;

import com.argentinaprograma.portfoliowebbackend.Model.PersonalInformation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository <PersonalInformation, Long>{
    @Override
    Optional<PersonalInformation> findById(Long id);
    
    Optional<PersonalInformation> findByUserId(Long user_id);
   
}
