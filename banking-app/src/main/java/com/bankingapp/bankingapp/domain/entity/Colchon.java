package com.bankingapp.bankingapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Colchon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colchon", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "saldo", length = 255)
    private BigDecimal saldo;
    @ManyToOne
    @JsonBackReference
    private User user;

    public Colchon() {
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Colchon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", saldo=" + saldo +
                ", user=" + user +
                '}';
    }
}
