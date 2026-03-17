package com.project.springboot.cencala.lavandery.controller;

import com.project.springboot.cencala.lavandery.dto.AuthRequest;
import com.project.springboot.cencala.lavandery.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody AuthRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        String token = jwtService.generateToken(request.getUsername());
        final ResponseCookie sessionCookie = ResponseCookie
                .from("sessionLaundry", token)
                .domain("localhost")
                .path("/")
                .httpOnly(true)
                .secure(false)
                .maxAge(60*60)
                .sameSite("Lax")
                .build();
        response.setHeader(HttpHeaders.SET_COOKIE, sessionCookie.toString());
        return ResponseEntity.noContent().build();
    }
}
