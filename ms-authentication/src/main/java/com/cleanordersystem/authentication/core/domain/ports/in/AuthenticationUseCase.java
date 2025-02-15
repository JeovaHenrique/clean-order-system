package com.cleanordersystem.authentication.core.domain.ports.in;

import com.cleanordersystem.authentication.adapters.in.dto.LoginRequest;
import com.cleanordersystem.authentication.adapters.in.dto.RefreshTokenRequest;
import com.cleanordersystem.authentication.adapters.in.dto.RegisterRequest;
import com.cleanordersystem.authentication.adapters.out.AuthenticationResponse;
import com.cleanordersystem.authentication.adapters.out.LogoutResponse;

public interface AuthenticationUseCase {
    AuthenticationResponse login(LoginRequest request);
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse refreshToken(RefreshTokenRequest request);
    LogoutResponse logout(String email);
}
