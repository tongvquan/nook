package com.tongquan.nook.application.port.out;

import com.tongquan.nook.domain.user.model.User;
import java.util.Optional;

public interface UserPort {
    Optional<User> findByUserName(String userName);
}
