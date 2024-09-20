package com.example.rest_43_1.dto;

import com.example.rest_43_1.domain.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchDto {

    @JsonProperty("producer")
    private String producerOfBicycle;
    @JsonProperty("type")
    private Type typeOfBicycle;

}
