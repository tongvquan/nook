package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.RoleEntity")
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nonnull
    @Column(name = "\"id\"", nullable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"code\"", nullable = false)
    private String code;

    @Nonnull
    @Column(name = "\"name\"", nullable = false)
    private String name;

    @Nullable
    @Column(name = "\"description\"", nullable = true)
    private String description;

    @Nonnull
    @Column(name = "\"created_at\"", nullable = false)
    private Timestamp createdAt;

    @Nonnull
    @Column(name = "\"updated_at\"", nullable = false)
    private Timestamp updatedAt;
}
