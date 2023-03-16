package com.bankingapp.bankingapp.domain.interfaces;

import com.bankingapp.bankingapp.adapters.dto.user.UserDTO;
import com.bankingapp.bankingapp.domain.Colchon;
import com.bankingapp.bankingapp.domain.Cuenta;
import com.bankingapp.bankingapp.domain.Transferencia;
import com.bankingapp.bankingapp.domain.entity.User;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface UserInterface extends banckInterface {
    UserDTO createUser(User user);
    List<User> getAllUser();

    UserDTO login(User user);

    Cuenta createCuenta(Long id, Cuenta account);

    void transferencia(Transferencia transferencia);
    void accountData(Cuenta cuenta);
    void colchon(Colchon colchon);
}
