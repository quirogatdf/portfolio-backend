package com.argentinaprograma.portfoliowebbackend.Repository;

import com.argentinaprograma.portfoliowebbackend.Model.PersonalInformation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository <PersonalInformation, Long>{
    List findByUserId(Long user_id);
}
