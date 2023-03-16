package com.bankingapp.bankingapp.application.services;

import com.bankingapp.bankingapp.domain.User;

import java.util.List;

public interface UserInterface {

    List<com.bankingapp.bankingapp.domain.entity.User> userView();

    com.bankingapp.bankingapp.domain.entity.User busarPorId(Long id);

    User crearUsuario(User account);

}
