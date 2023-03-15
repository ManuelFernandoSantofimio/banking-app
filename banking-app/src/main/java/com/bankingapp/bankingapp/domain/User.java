package com.bankingapp.bankingapp.domain;

import java.util.List;

public class User {
    private Long id;
    private String fullName;
    private String email;
    private String pass;
    private List<Cuenta> cuentas;
}
