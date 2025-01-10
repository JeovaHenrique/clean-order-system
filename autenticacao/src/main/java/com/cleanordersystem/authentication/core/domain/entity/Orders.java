package com.cleanordersystem.authentication.core.domain.entity;

import com.cleanordersystem.authentication.core.domain.enums.StatusOrders;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private String orderNumber;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private StatusOrders orderStatus;

    @Column(name = "order_value", precision = 20, scale = 2)
    private BigDecimal totalOrderValue;

    @Column(name = "order_description")
    private String orderDescription;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client orderClient;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee orderEmployee;

}
