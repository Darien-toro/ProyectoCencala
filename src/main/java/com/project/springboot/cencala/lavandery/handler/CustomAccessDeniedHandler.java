package com.project.springboot.cencala.lavandery.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springboot.cencala.lavandery.dto.ErrorResponseDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private final ObjectMapper objectMapper;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ErrorResponseDTO errorResponse = ErrorResponseDTO
                .builder()
                .code(String.valueOf(HttpStatus.FORBIDDEN.value()))
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .status(HttpStatus.FORBIDDEN.value())
                .httpStatus(HttpStatus.FORBIDDEN.getReasonPhrase())
                .message(accessDeniedException.getLocalizedMessage())
                .build();
        response.setStatus(errorResponse.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
