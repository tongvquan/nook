package com.tongquan.nook.adapter.in.web.security;

import com.tongquan.nook.adapter.out.persistence.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtToAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final UserDetailsService userDetailsService;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        String username = jwt.getSubject();
        if (username == null) {
            throw new UsernameNotFoundException("");
        }

        CustomUserDetails user = (CustomUserDetails) userDetailsService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
}
