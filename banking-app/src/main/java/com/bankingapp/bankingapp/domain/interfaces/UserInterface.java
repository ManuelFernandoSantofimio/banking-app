package com.bankingapp.bankingapp.domain.interfaces;

import com.bankingapp.bankingapp.domain.Colchon;
import com.bankingapp.bankingapp.domain.Cuenta;
import com.bankingapp.bankingapp.domain.Transferencia;
import com.bankingapp.bankingapp.domain.entity.User;
import org.springframework.stereotype.Controller;

@Controller
public interface UserInterface extends banckInterface {
    User createUser(User user);

    com.bankingapp.bankingapp.domain.entity.User login(com.bankingapp.bankingapp.domain.entity.User user);

    Cuenta createCuenta(Long id, Cuenta account);

    void transferencia(Transferencia transferencia);
    void accountData(Cuenta cuenta);
    void colchon(Colchon colchon);
}
