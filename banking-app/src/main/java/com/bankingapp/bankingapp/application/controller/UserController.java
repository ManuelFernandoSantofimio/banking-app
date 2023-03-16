package com.bankingapp.bankingapp.application.controller;

import com.bankingapp.bankingapp.adapters.dto.user.UserConverter;
import com.bankingapp.bankingapp.adapters.dto.user.UserDTO;
import com.bankingapp.bankingapp.domain.Colchon;
import com.bankingapp.bankingapp.domain.Cuenta;
import com.bankingapp.bankingapp.domain.Transferencia;
import com.bankingapp.bankingapp.domain.entity.User;
import com.bankingapp.bankingapp.domain.interfaces.UserInterface;
import com.bankingapp.bankingapp.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Controller
public class UserController implements UserInterface {

    private final UserRepository userdb;

    public UserController(UserRepository userdb) {
        this.userdb = userdb;
    }


    @Override
    public UserDTO login(User user) {
        return null;
    }



    @Override
    public UserDTO createUser(User user) {
        UserConverter converter = new UserConverter();
        User savedUser = userdb.save(user);
        UserDTO userDTO = converter.fromEntity(savedUser);
        return userDTO;
    }

    @Override
    public com.bankingapp.bankingapp.domain.User login(com.bankingapp.bankingapp.domain.User user) {
        return null;
    }

    @Override
    public UserController createUser(UserController user) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        UserConverter converter = new UserConverter();
        List<UserDTO> userDTO = converter.fromEntity(userdb.findAll());
        List<User> x = userdb.findAll();

        return x;
    }

    @Override
    public Cuenta createCuenta(Long id, Cuenta account) {
        User user = userdb.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

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
