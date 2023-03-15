package com.bankingapp.bankingapp.domain;

public interface banckInterface {
    void login(User user);

    Cuenta createCuenta(Long id, Cuenta account);

    void transferencia(Transferencia transferencia);
    void accountData(Cuenta cuenta);
    void colchon(Colchon colchon);
}
