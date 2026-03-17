package com.project.springboot.cencala.lavandery.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springboot.cencala.lavandery.dto.ErrorResponseDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AuthEntryPointJwt implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ErrorResponseDTO errorResponse = ErrorResponseDTO
                .builder()
                .code(String.valueOf(HttpStatus.UNAUTHORIZED.value()))
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .status(HttpStatus.UNAUTHORIZED.value())
                .httpStatus(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message(authException.getLocalizedMessage())
                .build();
        response.setStatus(errorResponse.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
