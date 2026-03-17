package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.entity.UserAccountEntity;
import com.project.springboot.cencala.lavandery.repository.UserAccountRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String SECRET = "K9mT2v8XQp4Yz7Jc5Rk1Wn6Fh3Bq0LsD9eUaGt8Vm2Px4HyZ";
    private final UserAccountRepository  userAccountRepository;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String username) {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("username not found"));
        JwtBuilder jwtBuilder = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getKey())
                .claim("role", userAccountEntity.getRole().getId());
        if (userAccountEntity.getCustomerEntity() != null && userAccountEntity.getCustomerEntity().getId() != null) {
            jwtBuilder.claim("customerId", userAccountEntity.getCustomerEntity().getId());
        }
        return jwtBuilder
                .compact();
    }

    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}
