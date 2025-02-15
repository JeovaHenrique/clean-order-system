package com.cleanordersystem.authentication.core.domain.ports.in;

import com.cleanordersystem.authentication.adapters.in.dto.UpdateProfileRequest;
import com.cleanordersystem.authentication.core.domain.models.User;

import java.util.Optional;

public interface UserUseCase {
    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);
    void updateUserProfile(String email, UpdateProfileRequest request);
}
