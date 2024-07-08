package org.example.config;

import org.example.spring.Horse;
import org.example.spring.User;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.example")

public class AppSpringConfig {

    @Bean
    public User user(){
        return new User(1000);
    }

    @Bean
    public Horse horse1() {
        return new Horse(1);
    }

    @Bean
    public Horse horse2() {
        return new Horse(2);
    }

    @Bean
    public Horse horse3() {
        return new Horse(3);
    }

    @Bean
    public Horse horse4() {
        return new Horse(4);
    }

    @Bean
    public Horse horse5() {
        return new Horse(5);
    }

}
