package com.cleanordersystem.authentication.adapters.persistence.repositories;

import com.cleanordersystem.authentication.adapters.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepositorySpringData extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByCpfUserOrEmail(String cpfOrEmail);
    void deleteByCpfUserOrEmail(String cpfOrEmail);
}
