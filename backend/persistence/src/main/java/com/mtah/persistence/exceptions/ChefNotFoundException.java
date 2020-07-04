package com.mtah.persistence.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChefNotFoundException extends RuntimeException {

    public ChefNotFoundException(String message) {
        super(message);
    }
}
