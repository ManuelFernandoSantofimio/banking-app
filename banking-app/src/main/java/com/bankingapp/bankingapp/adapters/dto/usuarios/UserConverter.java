package com.bankingapp.bankingapp.adapters.dto.usuarios;

import com.bankingapp.bankingapp.domain.AbstractConverter;
import com.bankingapp.bankingapp.domain.entity.Usuario;

import java.util.List;

public class UserConverter extends AbstractConverter<Usuario, UserDTO> {
    @Override
    public Usuario fromDto(UserDTO dto) {
        Usuario user = new Usuario();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    @Override
    public UserDTO fromEntity(Usuario entity) {
        UserDTO user = new UserDTO();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        return user;
    }
}
