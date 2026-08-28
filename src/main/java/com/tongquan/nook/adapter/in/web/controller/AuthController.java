package com.tongquan.nook.adapter.in.web.controller;

import com.tongquan.nook.adapter.in.web.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return null;
    }
}
