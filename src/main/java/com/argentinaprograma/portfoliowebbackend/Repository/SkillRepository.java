
package com.argentinaprograma.portfoliowebbackend.Repository;

import com.argentinaprograma.portfoliowebbackend.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
    
}
