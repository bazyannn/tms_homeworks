package com.example.spring_security_46.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
