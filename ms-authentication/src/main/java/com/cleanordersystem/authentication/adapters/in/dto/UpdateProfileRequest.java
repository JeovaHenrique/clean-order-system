package com.cleanordersystem.authentication.adapters.in.dto;

import com.cleanordersystem.authentication.core.domain.enums.RolesEnum;
import jakarta.validation.constraints.Email;
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
public class UpdateProfileRequest {

    @NotBlank(message = "O CPF do usuário é obrigatório")
    private String cpfUser;

    @Size(min = 3, message = "O nome deve ter pelo menos 3 caracteres")
    private String username;

    @Email(message = "E-mail inválido")
    private String email;

    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String password;

    private RolesEnum userRole;
}