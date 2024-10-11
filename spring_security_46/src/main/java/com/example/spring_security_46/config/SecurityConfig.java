package com.example.spring_security_46.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable)   //отключаем защиту cors
                .csrf(customizer -> customizer.disable())   //отключаем защиту csrf
                .formLogin(customizer -> {     //процедура Log In
                    customizer.loginPage("/login");                   //страница, где находится форма
                    customizer.loginProcessingUrl("/mylogin");  //url, по которому летит форма
                    customizer.usernameParameter("login");     //то что является username
                    customizer.passwordParameter("pass");      //то что является username
                    customizer.successHandler((req, resp, auth) -> {       //если всё хорошо
                        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
                        for (var authority : authorities) {
                            if (authority.toString().equals("ROLE_ADMIN")) {
                                resp.sendRedirect("/admin");
                            } else {
                                resp.sendRedirect("/auth");
                            }
                        }
                    });
                    customizer.failureHandler((req, resp, ex) -> {     //если всё плохо
                        resp.sendRedirect("/register");
                    });
                })
                .logout(cust -> {           //процедура Log Out
                    cust.logoutUrl("/mylogout");  //url, по которому летит форма
                    cust.logoutSuccessHandler((request, response, authentication) -> {  //если всё хорошо
                        request.getSession().invalidate();
                        response.sendRedirect("/register");
                    });
                })
                .authorizeHttpRequests(cust -> {
                    cust.requestMatchers("/auth").authenticated();             //паттерн - доступ, только аутентифицированные пользователи
                    cust.requestMatchers("/admin").hasRole("ADMIN");      //паттерн - доступ, только пользователи с определённой ролью
                    cust.requestMatchers("/register", "/login").permitAll();  //паттерн - доступ всем
                    cust.requestMatchers(HttpMethod.DELETE, "/delete").denyAll();  // метод и паттерн, к которым применяется действие(очень актуально для Rest-ов)
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    /*В проекте лучше сразу закладывать разные ветки endpoint-ов: //white...//black...//auth.. и т.д. И тогда можно
    удобно настраивать security. Используя паттерн "/white/**..." можно ограничить всё, что начинается с /white */

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
