package com.bankingapp.bankingapp.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class User {
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Colchon> colchones;
}
