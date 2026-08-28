package com.tongquan.nook.adapter.in.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import javax.crypto.SecretKey;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtIssuer {
    private final JwtProperties properties;

    public String issue(Request request) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + properties.getExpiration());

        return Jwts.builder()
                .subject(request.getUserName())
                .issuedAt(now)
                .expiration(expiration)
                .claim("userId", request.getUserId())
                .claim("role", request.getRoles())
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(properties.getSecretKey().getBytes(StandardCharsets.UTF_8));
    }

    @Getter
    @Builder
    public static class Request {
        private final Long userId;
        private final String userName;
        private final List<String> roles;
    }
}
