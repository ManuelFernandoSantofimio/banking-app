package com.bankingapp.bankingapp.domain.entity;

import jakarta.persistence.*;


@Entity
@Table
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "pass", length = 255)
    private String pass;

}
