package com.example.rest_42.domain;

import com.example.rest_42.dto.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Student {
    @Id
    @UuidGenerator
    private UUID id;

    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Integer yearOfBirthday;
    private Integer numberOfClass;
    private String address;

}
