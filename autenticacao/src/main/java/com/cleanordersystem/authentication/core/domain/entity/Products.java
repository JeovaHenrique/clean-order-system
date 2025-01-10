package com.cleanordersystem.authentication.core.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "dimension_length")
    private Double dimensionLength;

    @Column(name = "dimension_width")
    private Double dimensionWidth;

    @Column(name = "dimension_height")
    private Double dimensionHeight;

    @Column(name = "service_value")
    private Double serviceValue;
}