package com.ieadalpe.ieadalpeapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.time.OffsetDateTime;
import java.util.Map;

@Configuration
public class SecurityExceptionHandlerConfig {

    @Bean
    AuthenticationEntryPoint authenticationEntryPoint(ObjectMapper objectMapper) {
        return (request, response, authException) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");

            objectMapper.writeValue(response.getOutputStream(), Map.of(
                    "timestamp", OffsetDateTime.now().toString(),
                    "status", 401,
                    "error", "Unauthorized",
                    "message", "Token ausente, inválido ou expirado.",
                    "path", request.getRequestURI()
            ));
        };
    }

    @Bean
    AccessDeniedHandler accessDeniedHandler(ObjectMapper objectMapper) {
        return (request, response, accessDeniedException) -> {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");

            objectMapper.writeValue(response.getOutputStream(), Map.of(
                    "timestamp", OffsetDateTime.now().toString(),
                    "status", 403,
                    "error", "Forbidden",
                    "message", "Você não tem permissão para acessar este recurso.",
                    "path", request.getRequestURI()
            ));
        };
    }
}