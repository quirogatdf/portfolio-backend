package com.argentinaprograma.portfoliowebbackend.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column( unique = true )
    private String username;
    @NotNull
    private String password;
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
    @Column(name = "profile_image")
    private String profileImage;
    @Column(name = "banner_image")
    private String bannerImage;

    public User() {
    }

    public User(Long id,@NotNull String username,@NotNull String password, LocalDateTime dateCreation, String profileImage, String bannerImage) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dateCreation = dateCreation;
        this.profileImage = profileImage;
        this.bannerImage = bannerImage;
    }

}
