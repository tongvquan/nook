package com.tongquan.nook.shared.constants;

public class SecurityConstants {
    private SecurityConstants() {}

    public static final String[] PUBLIC_ENDPOINTS = {
        AppConstants.API_PREFIX + "/auth/**",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/v3/api-docs/**",
        "/actuator/health"
    };
}
