package com.bankingapp.bankingapp.application.controller;

import com.bankingapp.bankingapp.adapters.dto.user.UserDTO;
import com.bankingapp.bankingapp.domain.*;
import com.bankingapp.bankingapp.domain.interfaces.banckInterface;
import com.bankingapp.bankingapp.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Random;

@Controller
public class Back implements banckInterface {
    private UserRepository userdb;

    public Back(UserRepository userdb) {
        this.userdb = userdb;
    }

    @Override
    public UserDTO login(com.bankingapp.bankingapp.domain.entity.User user) {
        return null;
    }

    @Override
    public UserDTO createUser(com.bankingapp.bankingapp.domain.entity.User user) {
        return null;
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public UserController createUser(UserController user) {
        return null;
    }

    @Override
    public Cuenta createCuenta(Long id, Cuenta account) {
        com.bankingapp.bankingapp.domain.entity.User user = userdb.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Cuenta cuenta = new Cuenta();
        Random random = new Random();

        int numAleatorio = random.nextInt(900000000) + 100000000;
        cuenta.setNumero(String.valueOf(numAleatorio));

        cuenta.setSaldo(BigDecimal.ZERO);

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
