package com.mtah.web.Exceptions;

import com.mtah.persistence.exceptions.ChefNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
        ChefNotFoundException.class
    })
    public ResponseEntity<?> handleNotFound(Exception ex, WebRequest request) {
        String uriPath =  ((ServletWebRequest)request).getRequest().getRequestURI();
        ApiResponseError response = ApiResponseError.builder()
            .message(ex.getMessage())
            .path(uriPath)
            .status(HttpStatus.BAD_REQUEST)
            .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
