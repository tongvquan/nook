package com.tongquan.nook.adapter.in.web.security;

import com.tongquan.nook.adapter.out.persistence.security.CustomUserDetails;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {
    private final CustomUserDetails customUserDetails;

    public UserPrincipalAuthenticationToken(CustomUserDetails customUserDetails) {
        super(customUserDetails.getAuthorities());
        this.customUserDetails = customUserDetails;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public CustomUserDetails getPrincipal() {
        return customUserDetails;
    }
}
