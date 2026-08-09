package com.tongquan.nook.infrastructure.security;

import com.tongquan.nook.application.port.in.UserUseCase;
import com.tongquan.nook.domain.user.model.User;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserUseCase userUseCase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userUseCase.findByUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        return CustomUserDetails.builder()
                .id(user.id())
                .username(user.username())
                .email(user.email())
                .fullName(user.fullName())
                .phone(user.phone())
                .status(user.status())
                .password(user.password())
                .build();
    }
}
