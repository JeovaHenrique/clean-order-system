package com.cleanordersystem.authentication.adapters.request.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "O CPF ou Email não pode estar em branco")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    private String password;
}
