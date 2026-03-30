package com.bookingsystem.api_gateway.config;

import com.bookingsystem.api_gateway.filter.JwtAuthenticationFilter;
import com.bookingsystem.api_gateway.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
public class GatewayConfig {

    private static final String SECRET = "my-secret-key-123456";

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(
                new SecretKeySpec(
                        SECRET.getBytes(StandardCharsets.UTF_8),
                        "HmacSHA256"
                )
        );
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtUtil jwtUtil) {
        return new JwtAuthenticationFilter(jwtUtil);
    }
}