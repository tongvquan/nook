package com.tongquan.nook.adapter.out.persistence.mapper;

import com.tongquan.nook.adapter.out.persistence.entity.UserEntity;
import com.tongquan.nook.domain.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {
    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getFullName(),
                entity.getPhone(),
                entity.getDateOfBirth() != null ? entity.getDateOfBirth().toString() : null,
                entity.getAvatarUrl(),
                entity.getStatus(),
                entity.isEmailVerified(),
                entity.getLastLoginAt() != null ? entity.getLastLoginAt().toString() : null,
                entity.getCreatedAt().toString(),
                entity.getUpdatedAt().toString());
    }
}
