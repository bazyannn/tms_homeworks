package com.example.rest_43_1.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentServiceException extends RuntimeException {

    private Integer code;
    private String message;
}
