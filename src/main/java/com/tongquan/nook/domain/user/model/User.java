package com.tongquan.nook.domain.user.model;

public record User(
        Long id,
        String username,
        String email,
        String password,
        String fullName,
        String phone,
        String dateOfBirth,
        String avatarUrl,
        String status,
        boolean emailVerified,
        String lastLoginAt,
        String createdAt,
        String updatedAt) {}
