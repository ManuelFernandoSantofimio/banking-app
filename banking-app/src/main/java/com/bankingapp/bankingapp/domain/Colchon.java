package com.bankingapp.bankingapp.domain;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@EnableJpaRepositories
public class Colchon {
    private Long id;
    private String name;
    private BigDecimal saldo;
}
