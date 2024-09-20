package com.example.rest_43_1.dto;


import com.example.rest_43_1.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BicycleDto {

    private UUID id;

    private String producer;

    private Type type;

    private Boolean isBusy;
}
