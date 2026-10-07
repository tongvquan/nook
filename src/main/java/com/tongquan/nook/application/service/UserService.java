package com.tongquan.nook.application.service;

import com.tongquan.nook.application.port.in.UserUseCase;
import com.tongquan.nook.application.port.out.UserPort;
import com.tongquan.nook.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {
    private final UserPort userPort;

    @Override
    public User findByUserName(String userName) {
        return userPort.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("auth.login.failed"));
    }
}
