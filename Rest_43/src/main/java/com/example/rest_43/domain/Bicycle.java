package com.example.rest_43.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "bicycles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bicycle implements Serializable {

    @Id
    @UuidGenerator
    private UUID id;

    private String producer;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "is_busy")
    private Boolean isBusy;
}
