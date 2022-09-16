package com.argentinaprograma.portfoliowebbackend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalInformationDTO {

    private Long id;
    private String name;
    private String lastname;
    private String title;
    private String about;
    private String phone;
    private String mail;
    private String profileImage;
    private String bannerImage;

    public PersonalInformationDTO() {
    }

    public PersonalInformationDTO(String name, String lastname, String title, String about, String phone, String mail, String profileImage, String bannerImage) {
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
