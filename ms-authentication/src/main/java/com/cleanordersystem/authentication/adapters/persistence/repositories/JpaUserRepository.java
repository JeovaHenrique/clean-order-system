package com.cleanordersystem.authentication.adapters.persistence.repositories;

import com.cleanordersystem.authentication.adapters.persistence.entities.UserEntity;
import com.cleanordersystem.authentication.adapters.persistence.mappes.UserMapper;
import com.cleanordersystem.authentication.core.domain.enums.RolesEnum;
import com.cleanordersystem.authentication.core.domain.models.User;
import com.cleanordersystem.authentication.core.domain.ports.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class JpaUserRepository implements UserRepository {

    private final JpaUserRepositorySpringData jpaRepo;
    private final UserMapper userMapper;

    @Autowired
    public JpaUserRepository(JpaUserRepositorySpringData jpaRepo, UserMapper userMapper) {
        this.jpaRepo = jpaRepo;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepo.findByEmail(email).map(this::toModel);
    }

    @Override
    public void save(User user) {
        jpaRepo.save(userMapper.toEntity(user));
    }

    @Override
    public void updatePassword(String email, String newPassword) {
        jpaRepo.findByEmail(email).ifPresent(user -> {
            user.setPassword(newPassword);
            jpaRepo.save(user);
        });
    }

    @Override
    public void updateUserInfo(String email, String username, RolesEnum role) {
        jpaRepo.findByEmail(email).ifPresent(user -> {
            user.setUsername(username);
            user.setEmail(email);
            user.setUserRole(role);
            jpaRepo.save(user);
        });
    }

    @Override
    public void deleteByEmail(String email) {
        jpaRepo.deleteByEmail(email);
    }

    private User toModel(UserEntity entity) {
        return this.userMapper.toDomain(entity);
    }
}