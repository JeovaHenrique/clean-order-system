package com.cleanordersystem.authentication.core.domain.ports;

import com.cleanordersystem.authentication.core.domain.enums.RolesEnum;
import com.cleanordersystem.authentication.core.domain.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String cpfOrEmail);
    void save(User user);
    void updatePassword(String cpf, String newPassword);
    void updateUserInfo(String cpf, String username, String email, RolesEnum role);
    void deleteByCpf(String cpf);
}
