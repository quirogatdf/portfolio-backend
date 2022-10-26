
package com.argentinaprograma.portfoliowebbackend.Repository;

import com.argentinaprograma.portfoliowebbackend.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{
    
}
