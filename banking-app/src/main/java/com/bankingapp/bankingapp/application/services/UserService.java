package com.bankingapp.bankingapp.application.services;

import com.bankingapp.bankingapp.domain.User;
import com.bankingapp.bankingapp.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInterface{


    private UserRepository userRepository;
    @Override
    public User crearUsuario(User user){
        return null;
    }
    @Override
    public com.bankingapp.bankingapp.domain.entity.User busarPorId(Long id){
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public List<com.bankingapp.bankingapp.domain.entity.User> userView(){
        return userRepository.findAll();
    }
}
