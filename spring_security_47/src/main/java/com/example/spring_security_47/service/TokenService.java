package com.example.spring_security_47.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Value("${app.secret}")
    private String secret;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

        String createToken(UserDetails userDetails) {
            String username = userDetails.getUsername();
            var authorities = userDetails.getAuthorities();

            var roles = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(","));

            return Jwts.builder()
                    .setSubject(username)
                    .claim("name", username)
                    .claim("roles", roles)
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();
        }

        public Authentication parseToken(String token) {
            Claims payload = Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getPayload();

            String username = payload.get("name", String.class);
            String auths = payload.get("roles", String.class);
            var list = auths.split(",");
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (var item : list ) {
                authorities.add(new SimpleGrantedAuthority(item));
            }
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username,null,authorities);
            return authentication;
        }

        public boolean isValidToken (String token) {
            try{
                Claims payload = Jwts.parser()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(token)
                        .getPayload();

                return true;
            } catch (Exception exc) {
                return false;
            }
        }
}
