package org.example.spring;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component

public class User {

    private int wallet;

    public User(int wallet) {
        this.wallet = wallet;
    }

}
