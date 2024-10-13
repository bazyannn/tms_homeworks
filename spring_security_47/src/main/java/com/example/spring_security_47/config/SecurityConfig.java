package com.example.spring_security_47.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final OurTokenAuthFilter tokenAuthFilter;

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .addFilterBefore(tokenAuthFilter, RequestCacheAwareFilter.class)
                .authorizeHttpRequests(cust -> {
                   cust.requestMatchers("/rest/auth").permitAll();
                   cust.requestMatchers("/rest/admin").hasRole("ADMIN");
                })
                .build();
    }

    @Bean
    UserDetailsManager userDetailsService(DataSource dataSource) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
        PasswordEncoder encoder = passwordEncoder();
        UserDetails user1 = User.withUsername("slava")
                .password(encoder.encode("qwerty"))
                .authorities("ROLE_ADMIN")
                .build();
        UserDetails user2 = User.withUsername("petya")
                .password(encoder.encode("qaz"))
                .authorities("ROLE_USER")
                .build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

        jdbcUserDetailsManager.setDataSource(dataSource);
        if (jdbcUserDetailsManager.userExists("slava")) {
            jdbcUserDetailsManager.updateUser(user1);
        } else jdbcUserDetailsManager.createUser(user1);

        if (jdbcUserDetailsManager.userExists("petya")) {
            jdbcUserDetailsManager.updateUser(user2);
        } else jdbcUserDetailsManager.createUser(user2);

        return jdbcUserDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
