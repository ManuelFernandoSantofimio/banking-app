package com.bankingapp.bankingapp.domain.interfaces;
import com.bankingapp.bankingapp.adapters.dto.user.UserDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.Colchon;
import com.bankingapp.bankingapp.domain.Cuenta;
import com.bankingapp.bankingapp.domain.Transferencia;
import com.bankingapp.bankingapp.domain.entity.User;

public interface banckInterface {
    UserDTO login(User user);

    UserDTO createUser(User user);

    com.bankingapp.bankingapp.domain.User login(com.bankingapp.bankingapp.domain.User user);

    UserController createUser(UserController user);

    Cuenta createCuenta(Long id, Cuenta account);

    void transferencia(Transferencia transferencia);

    void accountData(Cuenta cuenta);

    void colchon(Colchon colchon);
}
