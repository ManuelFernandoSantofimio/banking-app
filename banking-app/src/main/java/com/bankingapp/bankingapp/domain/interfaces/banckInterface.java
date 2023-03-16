package com.bankingapp.bankingapp.domain.interfaces;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.Colchon;
import com.bankingapp.bankingapp.domain.Cuenta;
import com.bankingapp.bankingapp.domain.Transferencia;
import com.bankingapp.bankingapp.domain.User;

public interface banckInterface {
    User login(User user);

    UserController createUser(UserController user);

    Cuenta createCuenta(Long id, Cuenta account);

    void transferencia(Transferencia transferencia);

    void accountData(Cuenta cuenta);

    void colchon(Colchon colchon);
}
