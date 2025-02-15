package com.cleanordersystem.authentication.core.services;

import com.cleanordersystem.authentication.adapters.in.dto.UpdateProfileRequest;
import com.cleanordersystem.authentication.core.domain.models.User;
import com.cleanordersystem.authentication.core.domain.ports.in.UserUseCase;
import com.cleanordersystem.authentication.core.domain.ports.out.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    @Transactional
    public void updateUserProfile(String email, UpdateProfileRequest request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        if (request.getUserRole() != null) {
            user.setUserRole(request.getUserRole());
        }

        user.setJwtSecret(UUID.randomUUID().toString());
        userRepository.save(user);
    }
}
