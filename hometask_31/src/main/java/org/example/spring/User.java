package org.example.spring;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component

public class User {

    private Integer count;

    private int horseId;

    private int bet;

    public User(Integer count) {
        this.count = count;
    }

}
