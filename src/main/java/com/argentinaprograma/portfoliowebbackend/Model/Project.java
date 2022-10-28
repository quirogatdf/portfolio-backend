/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprograma.portfoliowebbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andi
 */
@Setter @Getter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Column(name="project_date")
    private String projectDate;
    private String description;
    @NotBlank
    @Column(name="url_repository")
    private String urlRepository;
    @Column(name="url_image")
    private String urlImage;

    public Project() {
    }

    public Project(String name, String projectDate, String description, String urlRepository, String urlImage) {
        this.name = name;
        this.projectDate = projectDate;
        this.description = description;
        this.urlRepository = urlRepository;
        this.urlImage = urlImage;
    }

    
}
