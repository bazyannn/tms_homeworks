package com.example.rest_43.dto;

import com.example.rest_43.domain.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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