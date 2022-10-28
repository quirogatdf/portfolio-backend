package com.argentinaprograma.portfoliowebbackend.Repository;

import com.argentinaprograma.portfoliowebbackend.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
