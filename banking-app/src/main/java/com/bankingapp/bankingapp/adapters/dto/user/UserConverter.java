package com.bankingapp.bankingapp.adapters.dto.user;

import com.bankingapp.bankingapp.domain.AbstractConverter;
import com.bankingapp.bankingapp.domain.entity.User;

import java.util.List;

public class UserConverter extends AbstractConverter<User, UserDTO> {

    @Override
    public User fromDto(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPass(dto.getPass());
        return user;
    }

    @Override
    public UserDTO fromEntity(User entity) {
        UserDTO user = new UserDTO();
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        return user;
    }
}
