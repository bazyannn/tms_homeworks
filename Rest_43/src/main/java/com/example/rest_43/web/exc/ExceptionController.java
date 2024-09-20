package com.example.rest_43.web.exc;

import com.example.rest_43.dto.ErrorDto;

import com.example.rest_43.exc.BicycleServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BicycleServiceException.class)
    public ResponseEntity<ErrorDto> handleBicycleServiceException(BicycleServiceException exc) {
        ErrorDto errorDto = new ErrorDto(exc.getCode(), exc.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }

}
