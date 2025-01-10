package com.cleanordersystem.authentication.core.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long idEmployee;

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "number_Cell_Phone", nullable = false)
    @NotEmpty
    @Pattern(regexp = "^[0-9]{11}$")
    private String numberCellPhone;
}
