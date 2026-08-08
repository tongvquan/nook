package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.UserEntity")
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    @Column(name = "\"id\"", nullable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"username\"", nullable = false)
    private String username;

    @Nonnull
    @Column(name = "\"email\"", nullable = false)
    private String email;

    @Nonnull
    @Column(name = "\"password\"", nullable = false)
    private String password;

    @Nonnull
    @Column(name = "\"full_name\"", nullable = false)
    private String fullName;

    @Nullable
    @Column(name = "\"phone\"", nullable = true)
    private String phone;

    @Nullable
    @Column(name = "\"date_of_birth\"", nullable = true)
    private Date dateOfBirth;

    @Nullable
    @Column(name = "\"avatar_url\"", nullable = true)
    private String avatarUrl;

    @Nonnull
    @Column(name = "\"status\"", nullable = false)
    private String status;

    @Column(name = "\"email_verified\"", nullable = false)
    private boolean emailVerified;

    @Nullable
    @Column(name = "\"last_login_at\"", nullable = true)
    private Timestamp lastLoginAt;

    @Nonnull
    @Column(name = "\"created_at\"", nullable = false)
    private Timestamp createdAt;

    @Nonnull
    @Column(name = "\"updated_at\"", nullable = false)
    private Timestamp updatedAt;
}
