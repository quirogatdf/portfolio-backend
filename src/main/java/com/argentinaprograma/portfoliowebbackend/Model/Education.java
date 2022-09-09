package com.argentinaprograma.portfoliowebbackend.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Education implements Serializable {

    @Id
    private Long id;
    
    
    public Education(){
        
    }
    
}
