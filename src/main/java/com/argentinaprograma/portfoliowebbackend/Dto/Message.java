package com.argentinaprograma.portfoliowebbackend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String message;
    private String status;
    public Message(String message, String status) {
        this.message = message;
        this.status = status;
    }
    
}
