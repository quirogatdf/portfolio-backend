package com.argentinaprograma.portfoliowebbackend.Model;

import com.argentinaprograma.portfoliowebbackend.Security.Model.User;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personal_information")
public class PersonalInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Last Name is required")
    private String lastname;
    private String title;
    private String about;
    private String phone;
    @Email
    private String mail;
    @Column(name = "profile_image", length=100)
    private String profileImage;
    @Column(name = "banner_image", length=100)
    private String bannerImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public PersonalInformation() {
    }

    public PersonalInformation(String name, String lastname, String title, String about, String phone, String mail, String profileImage, String bannerImage) {
        this.name = name;
        this.lastname = lastname;
        this.title = title;
        this.about = about;
        this.phone = phone;
        this.mail = mail;
        this.profileImage = profileImage;
        this.bannerImage = bannerImage;
    }

    
    
}
