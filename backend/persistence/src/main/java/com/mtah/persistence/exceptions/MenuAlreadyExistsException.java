package com.mtah.persistence.exceptions;

public class MenuAlreadyExistsException extends RuntimeException{

    public MenuAlreadyExistsException(String message) {
        super(message);
    }
}
