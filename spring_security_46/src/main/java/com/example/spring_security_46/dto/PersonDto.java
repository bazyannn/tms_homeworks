package com.example.spring_security_46.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {

    private String login;

    private String password;

    private String role;
}
