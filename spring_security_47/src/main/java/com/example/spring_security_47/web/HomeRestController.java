package com.example.spring_security_47.web;

import com.example.spring_security_47.dto.AuthRequestDto;
import com.example.spring_security_47.dto.AuthResponseDto;
import com.example.spring_security_47.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class HomeRestController {

    private final AuthService authService;
    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto requestDto) {
        return authService.auth(requestDto);
    }

    @PostMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
