package com.tongquan.nook.adapter.out.persistence.security;

import com.tongquan.nook.application.port.in.UserUseCase;
import com.tongquan.nook.domain.user.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserUseCase userUseCase;

    @Override
    @NonNull
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = userUseCase.findByUserName(username);
        //        List<GrantedAuthority> authorities = new ArrayList<>();
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
