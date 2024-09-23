package com.example.rest_43.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BicycleServiceException extends RuntimeException {

    private Integer code;
    private String message;
}
