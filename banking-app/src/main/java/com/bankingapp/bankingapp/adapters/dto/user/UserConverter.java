package com.bankingapp.bankingapp.adapters.dto.user;

import com.bankingapp.bankingapp.domain.AbstractConverter;
import com.bankingapp.bankingapp.domain.User;

import java.util.List;

public class UserConverter extends AbstractConverter<User, UserDTO> {
    @Override
    public User fromDto(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        return null;
    }

    @Override
    public UserDTO fromEntity(User entity) {
        UserDTO user = new UserDTO();
        user.setId(entity.getId());
        user.setUsername(entity.getName());
        user.setPassword(entity.getPass());
        return null;
    }
}
