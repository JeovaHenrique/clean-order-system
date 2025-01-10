package com.cleanordersystem.authentication.core.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "cpf_client", unique = true, nullable = false)
    @NotEmpty
    @CPF
    private String cpfClient;

    @Column(name = "phone_number", nullable = false)
    @NotEmpty
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    @NotEmpty
    private String email;

    @Column(name = "address", nullable = false)
    @NotEmpty
    private String address;

    @Column(name = "city", nullable = false)
    @NotEmpty
    private String city;

    @Column(name = "state", nullable = false)
    @NotEmpty
    private String state;

    @Column(name = "zip_code", nullable = false)
    @NotEmpty
    private String zipCode;

    @JsonIgnore
    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private Set<Orders> orders;

    public Client(String name, String cpfClient) {
        this.name = name;
        this.cpfClient = cpfClient;
    }

}
