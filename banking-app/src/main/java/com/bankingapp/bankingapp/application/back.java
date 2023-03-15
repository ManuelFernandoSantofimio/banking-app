package com.bankingapp.bankingapp.application;

import com.bankingapp.bankingapp.domain.*;
import jakarta.persistence.EntityNotFoundException;

import java.math.BigDecimal;
import java.util.Random;

public class back implements banckInterface {
    private UserInterfaceService userdb;

    public back(UserInterfaceService userdb) {
        this.userdb = userdb;
    }

    @Override
    public void login(User user) {

    }

    @Override
    public Cuenta createCuenta(Long id, Cuenta account) {
        User user = userdb.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Cuenta cuenta = new Cuenta();
        Random random = new Random();

        int numAleatorio = random.nextInt(900000000) + 100000000;
        cuenta.setNumero(String.valueOf(numAleatorio));

        cuenta.setSaldo(BigDecimal.ZERO);
        user.getCuentas().add(cuenta);
        userdb.save(user);
        return cuenta;
    }

    @Override
    public void transferencia(Transferencia transferencia) {

    }

    @Override
    public void accountData(Cuenta cuenta) {

    }

    @Override
    public void colchon(Colchon colchon) {

    }
}
