package com.bankingapp.bankingapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Long cuentaOrigen;
    @Column(name = "saldo", length = 255)
    private Long cuentaDestino;
    @Column(name = "monto", length = 255)
    private BigDecimal monto;

    public Transferencia() {
    }

    public Transferencia(Long cuentaOrigen, Long cuentaDestino, BigDecimal monto) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
    }

    public Long getCuentaOrigen() {
        return this.cuentaOrigen;
    }

    public Long getCuentaDestino() {
        return cuentaDestino;
    }

    public BigDecimal getMonto() {
        return this.monto;
    }

    public void setCuentaOrigen(Long cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public void setCuentaDestino(Long cuentaDestino) {
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
                '}';
    }
}
