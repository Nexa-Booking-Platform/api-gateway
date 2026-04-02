package com.bookingsystem.api_gateway.config;

import com.bookingsystem.api_gateway.filter.JwtAuthenticationFilter;
import com.bookingsystem.api_gateway.util.JwtUtil;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class GatewayConfig {

    @Value("${jwt.secret:default-very-long-secret-key-at-least-256-bits-long-for-hmac-sha256}")
    private String secret;

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(
                Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8))
        );
    }
}