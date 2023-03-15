package com.bankingapp.bankingapp.domain;

import java.util.List;

public class User {
    private Long id;
    private String Name;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    private String pass;
    private List<Cuenta> cuentas;
}
