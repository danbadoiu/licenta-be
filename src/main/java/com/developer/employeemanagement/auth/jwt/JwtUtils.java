package com.developer.employeemanagement.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Data
@RequiredArgsConstructor
public class JwtUtils {
    public static final String SECRET_KEY = "5A7134743777217A25432A462D4A614E645267556B58703273357538782F413F";

    public String generateJwtToken(UserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", user.getUsername());
        return Jwts.builder().setSubject(user.getUsername()).setClaims(claims).setIssuedAt(new Date()).setExpiration(new Date((new Date().getTime() + 86400000))).signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    public String extractUsername(String token) {
        return (String) extractAllClaims(token).get("user");
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    private Key getSigningKey() {
        byte[] keyBites = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBites);
    }

    public boolean validateJwtToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return Objects.equals(username, userDetails.getUsername()) && verifyTokenNotExpired(token);
    }

    private boolean verifyTokenNotExpired(String token) {
        return extractExpiration(token).after(new Date());
    }

    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }
}
