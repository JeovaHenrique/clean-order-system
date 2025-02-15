package com.cleanordersystem.authentication.adapters.in.controllers;

import com.cleanordersystem.authentication.adapters.in.dto.LoginRequest;
import com.cleanordersystem.authentication.adapters.in.dto.RefreshTokenRequest;
import com.cleanordersystem.authentication.adapters.in.dto.RegisterRequest;
import com.cleanordersystem.authentication.adapters.out.AuthenticationResponse;
import com.cleanordersystem.authentication.adapters.out.LogoutResponse;
import com.cleanordersystem.authentication.core.domain.ports.in.AuthenticationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationUseCase authenticationUseCase;

    public AuthenticationController(AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationUseCase.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationUseCase.register(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(authenticationUseCase.refreshToken(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(@RequestParam String email) {
        return ResponseEntity.ok(authenticationUseCase.logout(email));
    }
}
