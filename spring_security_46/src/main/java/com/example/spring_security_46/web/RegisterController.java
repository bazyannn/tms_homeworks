package com.example.spring_security_46.web;

import com.example.spring_security_46.dto.PersonDto;
import com.example.spring_security_46.service.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final PersonDetailsService personDetailsService;

    @GetMapping
    public String register() {
        return "register";
    }

    @PostMapping
    public String register(PersonDto person) {
        personDetailsService.save(person);
        return "redirect:/register";
    }
}
