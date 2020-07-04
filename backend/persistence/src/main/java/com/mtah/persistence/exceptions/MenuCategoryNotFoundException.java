package com.mtah.persistence.exceptions;

public class MenuCategoryNotFoundException extends RuntimeException {

    private String message;

    public MenuCategoryNotFoundException(String message) {
        this.message = message;
    }
}
