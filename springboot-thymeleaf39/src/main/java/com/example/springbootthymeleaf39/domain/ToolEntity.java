package com.example.springbootthymeleaf39.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "tools")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class ToolEntity {

    @Id
    @UuidGenerator
    private UUID id;
    private String title;
    private Integer cost;
    private Integer count;
    @Column(name = "is_delivered")
    private Boolean isDelivered;
    private Boolean deleted;
}
