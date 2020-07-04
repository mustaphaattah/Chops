package com.mtah.web.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
public class ApiResponseError {

    private String path;
    private HttpStatus status;
    private String message;
}
