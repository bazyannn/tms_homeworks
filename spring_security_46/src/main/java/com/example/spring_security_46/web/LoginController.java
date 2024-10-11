package com.example.spring_security_46.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "login";
    }

//    @PostMapping()
//    public String login(@RequestParam("login") String login, @RequestParam("pass") String password) {
//        return "redirect:/auth";
//    }
}
