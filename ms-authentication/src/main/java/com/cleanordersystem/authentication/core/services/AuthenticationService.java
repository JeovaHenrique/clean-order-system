package com.cleanordersystem.authentication.core.services;

import com.cleanordersystem.authentication.adapters.in.dto.LoginRequest;
import com.cleanordersystem.authentication.adapters.in.dto.RefreshTokenRequest;
import com.cleanordersystem.authentication.adapters.in.dto.RegisterRequest;
import com.cleanordersystem.authentication.adapters.out.AuthenticationResponse;
import com.cleanordersystem.authentication.adapters.out.LogoutResponse;
import com.cleanordersystem.authentication.config.security.JwtService;
import com.cleanordersystem.authentication.core.domain.models.User;
import com.cleanordersystem.authentication.core.domain.ports.in.AuthenticationUseCase;
import com.cleanordersystem.authentication.core.domain.ports.out.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService implements AuthenticationUseCase {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user.getEmail());

        return new AuthenticationResponse(accessToken, refreshToken);
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserRole(request.getUserRole());
        user.setJwtSecret(jwtService.generateToken(user));

        userRepository.save(user);

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user.getEmail());

        return new AuthenticationResponse(accessToken, refreshToken);
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequest request) {
        String email = jwtService.extractUsername(request.getRefreshToken());

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty() || !jwtService.isTokenValid(request.getRefreshToken(), email)) {
            throw new RuntimeException("Refresh token inválido ou expirado");
        }

        String newAccessToken = jwtService.generateToken(userOptional.get());
        return new AuthenticationResponse(newAccessToken, request.getRefreshToken());
    }

    @Override
    public LogoutResponse logout(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setJwtSecret(UUID.randomUUID().toString());
        userRepository.save(user);
        return new LogoutResponse("Logout realizado com sucesso! Tokens anteriores foram invalidados.");
    }
}
