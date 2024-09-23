package com.example.rest_43_1.web.exc;

import com.example.rest_43_1.dto.ErrorDto;
import com.example.rest_43_1.exc.RentServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RentServiceException.class)
    public ResponseEntity<ErrorDto> handleBicycleServiceException(RentServiceException exc) {
        ErrorDto errorDto = new ErrorDto(exc.getCode(), exc.getMessage());
        return ResponseEntity.badRequest().body(errorDto);
    }
}
