package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.RefreshTokenEntity")
@Table(name = "refresh_tokens")
public class RefreshTokenEntity {

    @Id
    @Nonnull
    @Column(name = "\"id\"", nullable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"user_id\"", nullable = false)
    private Long userId;

    @Nonnull
    @Column(name = "\"refresh_token\"", nullable = false)
    private String refreshToken;

    @Nullable
    @Column(name = "\"ip_address\"", nullable = true)
    private String ipAddress;

    @Nullable
    @Column(name = "\"device_name\"", nullable = true)
    private String deviceName;

    @Nullable
    @Column(name = "\"user_agent\"", nullable = true)
    private String userAgent;

    @Column(name = "\"is_revoked\"", nullable = true)
    private boolean isRevoked;

    @Nullable
    @Column(name = "\"expires_at\"", nullable = true)
    private Timestamp expiresAt;

    @Nullable
    @Column(name = "\"created_at\"", nullable = true)
    private Timestamp createdAt;
}
