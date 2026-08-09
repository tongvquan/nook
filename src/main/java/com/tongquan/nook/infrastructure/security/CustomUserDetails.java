package com.tongquan.nook.infrastructure.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tongquan.nook.domain.user.enums.UserStatus;
import java.util.Collection;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
public class CustomUserDetails implements UserDetails {
    private final Long id;
    private final String username;
    private final String email;
    private final String fullName;
    private final String phone;
    private final String status;

    @JsonIgnore
    private final String password;

    private final List<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !status.equals(UserStatus.LOCKED.name());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return status.equals(UserStatus.ACTIVE.name());
    }
}
