package com.bankingapp.bankingapp.adapters.inbound.dto.cuenta;

import java.math.BigDecimal;

public class CuentaDTO {
    private Long id;
    private  String numero;
    private BigDecimal saldo;

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
        return "CuentaDTO{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
