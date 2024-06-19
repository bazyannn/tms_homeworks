package org.example.config;

import org.example.spring.interfaces.impl.HorseImpl;
import org.example.spring.User;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("org.example.spring")

public class AppSpringConfig {

    @Bean
    public User user(){
        return new User(1000);
    }

    @Bean
    public HorseImpl horse1() {
        return new HorseImpl(1);
    }

    @Bean
    public HorseImpl horse2() {
        return new HorseImpl(2);
    }

    @Bean
    public HorseImpl horse3() {
        return new HorseImpl(3);
    }

    @Bean
    public HorseImpl horse4() {
        return new HorseImpl(4);
    }

    @Bean
    public HorseImpl horse5() {
        return new HorseImpl(5);
    }

}
