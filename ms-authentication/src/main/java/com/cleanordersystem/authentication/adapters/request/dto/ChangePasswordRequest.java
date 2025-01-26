package com.cleanordersystem.authentication.adapters.request.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChangePasswordRequest {

    @NotBlank(message = "O Email do usuário é obrigatório")
    private String email;

    @NotBlank(message = "A senha atual é obrigatória")
    private String currentPassword;

    @NotBlank(message = "A nova senha é obrigatória")
    @Size(min = 6, message = "A nova senha deve ter pelo menos 6 caracteres")
    private String newPassword;
}