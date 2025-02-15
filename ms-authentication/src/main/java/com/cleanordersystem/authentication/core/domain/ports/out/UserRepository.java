package com.cleanordersystem.authentication.core.domain.ports.out;

import com.cleanordersystem.authentication.core.domain.enums.RolesEnum;
import com.cleanordersystem.authentication.core.domain.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
    void updatePassword(String cpf, String newPassword);
    void updateUserInfo( String email, String username, RolesEnum role);
    void deleteByEmail(String email);
}
