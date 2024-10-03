package com.example.spring_security_45.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/task")
    public String task() {
        return "task";
    }

    @GetMapping("/order")
    public String order() {
        return "order";
    }
}
