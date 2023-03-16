package com.bankingapp.bankingapp.domain;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@EnableJpaRepositories
public class Transferencia {
    private Long id;
    private String numero;
    private BigDecimal monto;

}
