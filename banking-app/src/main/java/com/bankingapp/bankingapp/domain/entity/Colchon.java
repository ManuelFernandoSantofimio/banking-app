package com.bankingapp.bankingapp.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Colchon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "saldo", length = 255)
    private BigDecimal saldo;
}
