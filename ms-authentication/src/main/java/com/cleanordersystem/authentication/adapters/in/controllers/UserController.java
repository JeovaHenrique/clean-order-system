package com.cleanordersystem.authentication.adapters.in.controllers;

import com.cleanordersystem.authentication.adapters.in.dto.UpdateProfileRequest;
import com.cleanordersystem.authentication.core.domain.models.User;
import com.cleanordersystem.authentication.core.domain.ports.in.UserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @GetMapping("/me")
    public ResponseEntity<User> getAuthenticatedUser(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userUseCase.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update-profile")
    public ResponseEntity<String> updateUserProfile(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody @Valid UpdateProfileRequest request
    ) {
        userUseCase.updateUserProfile(userDetails.getUsername(), request);
        return ResponseEntity.ok("Perfil atualizado com sucesso!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        userUseCase.deleteByEmail(userDetails.getUsername());
        return ResponseEntity.ok("Usuário deletado com sucesso.");
    }
}
