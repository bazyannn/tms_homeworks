package com.example.rest_42.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
    private UUID id;
    private String name;
    private String surname;
    private Sex sex;
    private Integer yearOfBirthday;
    private Integer numberOfClass;
    private String address;

}
