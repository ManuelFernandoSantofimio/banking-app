package com.bankingapp.bankingapp.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transferencia", nullable = false, unique = true)
    private Long id;
    @Column(name = "numero", length = 255)
    private String cuentaOrigen;
    @Column(name = "saldo", length = 255)
    private String cuentaDestino;
    @Column(name = "saldo", length = 255)
    private BigDecimal monto;
    @ManyToOne
    private User user;

    public Transferencia() {
    }

    public Transferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", cuentaOrigen='" + cuentaOrigen + '\'' +
                ", cuentaDestino='" + cuentaDestino + '\'' +
                ", monto=" + monto +
                ", user=" + user +
                '}';
    }
}
