package com.tongquan.nook.adapter.in.web.dto.response;

public record LoginResponse(String accessToken, String refreshToken, String tokenType, long expiresIn) {}
