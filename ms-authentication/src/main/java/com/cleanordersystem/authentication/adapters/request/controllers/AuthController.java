package com.cleanordersystem.authentication.adapters.request.controllers;

import com.cleanordersystem.authentication.adapters.request.dto.LoginRequest;
import com.cleanordersystem.authentication.adapters.request.dto.RefreshTokenRequest;
import com.cleanordersystem.authentication.adapters.request.dto.RegisterRequest;
import com.cleanordersystem.authentication.adapters.response.AuthenticationResponse;
import com.cleanordersystem.authentication.adapters.response.LogoutResponse;
import com.cleanordersystem.authentication.core.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(authService.refreshToken(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(@RequestParam String email) {
        return ResponseEntity.ok(authService.logout(email));
    }
}
