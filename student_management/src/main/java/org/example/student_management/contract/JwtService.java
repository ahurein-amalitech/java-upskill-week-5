package org.example.student_management.contract;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String extractUsername(String token);

    Claims extractAllClaims(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    String generateToken(Map<String, Object> claims, UserDetails userDetails);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
}
