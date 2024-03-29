package com.bankingapp.bankingapp.domain;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@EnableJpaRepositories
public class Cuenta {
    private Long id;
    private String numero;
    private BigDecimal saldo;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
