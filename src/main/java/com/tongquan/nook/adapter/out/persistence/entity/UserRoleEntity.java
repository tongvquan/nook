package com.tongquan.nook.adapter.out.persistence.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity(name = "com.tongquan.nook.adapter.out.persistence.entity.UserRoleEntity")
@Table(name = "user_role")
@IdClass(UserRoleEntity.PrimaryKeys.class)
public class UserRoleEntity {
    @Data
    public static class PrimaryKeys implements Serializable {
        private Long userId;
        private Long roleId;
    }

    @Id
    @Nonnull
    @Column(name = "\"user_id\"", nullable = false)
    private Long userId;

    @Id
    @Nonnull
    @Column(name = "\"role_id\"", nullable = false)
    private Long roleId;

    @Nonnull
    @Column(name = "\"created_at\"", nullable = false)
    private Timestamp createdAt;
}
