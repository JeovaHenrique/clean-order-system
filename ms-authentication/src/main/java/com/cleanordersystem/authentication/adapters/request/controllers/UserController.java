package com.cleanordersystem.authentication.adapters.request.controllers;

import com.cleanordersystem.authentication.adapters.request.dto.UpdateProfileRequest;
import com.cleanordersystem.authentication.core.domain.models.User;
import com.cleanordersystem.authentication.core.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> getAuthenticatedUser(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update-profile")
    public ResponseEntity<String> updateUserProfile(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody @Valid UpdateProfileRequest request
    ) {
        userService.updateUserProfile(userDetails.getUsername(), request);
        return ResponseEntity.ok("Perfil atualizado com sucesso!");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        userService.deleteByEmail(userDetails.getUsername());
        return ResponseEntity.ok("Usuário deletado com sucesso.");
    }
}
