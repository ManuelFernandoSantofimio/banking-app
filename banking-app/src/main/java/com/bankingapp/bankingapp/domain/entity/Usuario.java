package com.bankingapp.bankingapp.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
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
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuenta> cuentas = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nombre, String apellido) {
        this.name = name;
        this.email = email;
    }
}
