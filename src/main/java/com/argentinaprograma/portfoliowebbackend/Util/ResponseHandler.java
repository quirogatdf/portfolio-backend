package com.argentinaprograma.portfoliowebbackend.Util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse (String message, HttpStatus status, Object resObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status);
        map.put("data", resObj);
        
        return new ResponseEntity<Object>(map,status);
        
    }
    
}
