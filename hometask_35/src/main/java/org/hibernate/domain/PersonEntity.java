package org.hibernate.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "persons")
@NoArgsConstructor @Getter @Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//  @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private Integer salary;
    @Enumerated(EnumType.STRING)
    private Type role;
}
