package com.tongquan.nook.application.service;

import com.tongquan.nook.adapter.in.web.dto.response.LoginResponse;
import com.tongquan.nook.adapter.in.web.security.JwtIssuer;
import com.tongquan.nook.adapter.out.persistence.security.CustomUserDetails;
import com.tongquan.nook.application.command.LoginCommand;
import com.tongquan.nook.application.port.in.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse execute(LoginCommand loginCommand) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginCommand.username(), loginCommand.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        String token = jwtIssuer.issue(JwtIssuer.Request.builder()
                .userId(principal.getId())
                .userName(principal.getUsername())
                .roles(principal.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList())
                .build());
        return new LoginResponse(token, null, null, 1);
    }
}
