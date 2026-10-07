package com.tongquan.nook.adapter.in.web.controller;

import com.tongquan.nook.adapter.in.web.dto.common.ApiResponse;
import com.tongquan.nook.adapter.in.web.dto.request.LoginRequest;
import com.tongquan.nook.adapter.in.web.dto.response.LoginResponse;
import com.tongquan.nook.application.command.LoginCommand;
import com.tongquan.nook.application.port.in.AuthUseCase;
import com.tongquan.nook.shared.constants.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstants.API_PREFIX)
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/auth/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(ApiResponse.success(
                authUseCase.execute(new LoginCommand(loginRequest.username(), loginRequest.password()))));
    }
}
