package app.web.pavelk.chat2.back1.auth.service;


import app.web.pavelk.chat2.back1.auth.dto.LoginResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
public class JwtProvider {

    private static final String secretKey = Base64.getEncoder().encodeToString("asfsaGFSDdfas@#$2dfasdd234saf".getBytes());
    private static final Long exp = 120L;

    public LoginResponseDto generateToken(org.springframework.security.core.userdetails.User principal) {
        Claims claims = Jwts.claims().setSubject(principal.getUsername());
        claims.put("role", principal.getAuthorities().toString());

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        LocalDateTime localDateTimeNowPlus = localDateTimeNow.plusMinutes(exp);

        return LoginResponseDto.builder()
                .token(Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(java.sql.Timestamp.valueOf(localDateTimeNow))
                        .signWith(SignatureAlgorithm.HS256, secretKey)
                        .setExpiration(java.sql.Timestamp.valueOf(localDateTimeNowPlus))
                        .compact())
                .expiresAt(localDateTimeNowPlus)
                .username(principal.getUsername()).build();
    }

    public String getUsernameAndValidateJwt(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
