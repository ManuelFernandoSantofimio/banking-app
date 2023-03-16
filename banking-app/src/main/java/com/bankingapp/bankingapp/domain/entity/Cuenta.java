package com.bankingapp.bankingapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta", nullable = false, unique = true)
    private Long id;
    @Column(name = "numero", length = 255)
    private String numero;
    @Column(name = "saldo", length = 255)
    private BigDecimal saldo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Cuenta() {}

    public Cuenta(BigDecimal saldo, Usuario usuario) {
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
