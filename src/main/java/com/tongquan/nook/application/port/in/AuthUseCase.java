package com.tongquan.nook.application.port.in;

import com.tongquan.nook.adapter.in.web.dto.response.LoginResponse;
import com.tongquan.nook.application.command.LoginCommand;

public interface AuthUseCase {
    LoginResponse execute(LoginCommand loginCommand);
}
