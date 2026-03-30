package com.bookingsystem.api_gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.Key;

public class JwtUtil {

    private final Key key;

    public JwtUtil(Key key) {
        this.key = key;
    }

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}