package com.tongquan.nook.adapter.out.persistence;

import com.tongquan.nook.adapter.out.persistence.mapper.UserPersistenceMapper;
import com.tongquan.nook.adapter.out.persistence.repository.UserJpaRepository;
import com.tongquan.nook.application.port.out.UserPort;
import com.tongquan.nook.domain.user.model.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserPort {
    private final UserJpaRepository userJpaRepository;

    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public Optional<User> findByUserName(String userName) {
        return userJpaRepository.findByUsername(userName).map(userPersistenceMapper::toDomain);
    }
}
