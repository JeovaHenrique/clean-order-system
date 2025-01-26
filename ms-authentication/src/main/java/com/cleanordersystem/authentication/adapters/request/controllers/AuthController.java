package com.cleanordersystem.authentication.adapters.request.controllers;

import com.cleanordersystem.authentication.adapters.request.dto.ChangePasswordRequest;
import com.cleanordersystem.authentication.adapters.request.dto.LoginRequest;
import com.cleanordersystem.authentication.adapters.request.dto.UpdateProfileRequest;
import com.cleanordersystem.authentication.core.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request.getCpfOrEmail(), request.getPassword()));
    }

    @PutMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordRequest request) {
        authService.changePassword(request);
        return ResponseEntity.noContent().build();
    }
}
