package com.example.springbootthymeleaf39.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "tools")
@NoArgsConstructor @Getter @Setter

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

    public ToolEntity(String title, Integer cost, Integer count, Boolean isDelivered) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.cost = cost;
        this.count = count;
        this.isDelivered = isDelivered;
    }
}
