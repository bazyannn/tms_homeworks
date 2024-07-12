package org.hibernate_2.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Getter @Setter
@ToString
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//  @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name; // так проще было отслеживать изменения в таблице
    private Integer age;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date updateDate;
    @Version
    private Integer version;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL) //cascade = CascadeType.ALL(так тоже верно будет? или лучше как указал?)
    private List<OrderEntity> orders = new ArrayList<>();

    public PersonEntity(String name, Integer age) {    // так проще было отслеживать изменения в таблице
        this.name = name;
        this.age = age;
    }

    public void addOrder(OrderEntity order) {
        orders.add(order);
        order.setPerson(this);
    }
}
