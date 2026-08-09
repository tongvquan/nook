package com.tongquan.nook.application.port.in;

import com.tongquan.nook.domain.user.model.User;

public interface UserUseCase {
    User findByUserName(String userName);
}
