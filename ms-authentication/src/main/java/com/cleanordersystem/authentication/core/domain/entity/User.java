package com.cleanordersystem.authentication.core.domain.entity;

import com.cleanordersystem.authentication.core.domain.enums.RolesEnum;
import com.cleanordersystem.authentication.core.domain.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user")
public class User {

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Id
    @Column(name = "cpf_user", unique = true, nullable = false)
    @NotEmpty
    @CPF
    private String cpfUser;

    @Column(name = "email", nullable = false)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "biometric_data")
    private String biometricData;

    @Column(name = "mfa_code")
    private String mfaCode;

    @Column(name = "password", nullable = false)
    @NotEmpty
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "role", nullable = false)
    @NotEmpty
    private String role;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    @Column(name = "Role of user", nullable = false)
    private RolesEnum userRole;
}
