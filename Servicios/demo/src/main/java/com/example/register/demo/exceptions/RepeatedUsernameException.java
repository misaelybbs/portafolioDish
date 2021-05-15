package com.example.register.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RepeatedUsernameException extends RuntimeException{

    public RepeatedUsernameException(String message) {
        super(message);
    }
}
