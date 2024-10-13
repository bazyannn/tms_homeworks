package com.example.spring_security_47.service;

import com.example.spring_security_47.dto.AuthRequestDto;
import com.example.spring_security_47.dto.AuthResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDetailsManager manager;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;

    public AuthResponseDto auth(AuthRequestDto requestDto) {

        UserDetails user = manager.loadUserByUsername(requestDto.getUsername());

        if (!encoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException();
        }
        String token = tokenService.createToken(user);
        return new AuthResponseDto(token);
    }
}
