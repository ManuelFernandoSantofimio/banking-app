package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.dto.usuarios.UserDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UsuarioRestControllerTest {
    @Mock
    private UserController userController;
    private UsuarioRestController usuarioRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        usuarioRestController = new UsuarioRestController(userController);
    }
    @Test
    void createUserTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Manuel Fernando");
        userDTO.setEmail("msantofimio@serempre.com");

        Usuario usuario = new Usuario();
        usuario.setName(userDTO.getName());
        usuario.setEmail(userDTO.getEmail());

        when(userController.createUser(any(Usuario.class))).thenReturn(userDTO);
        MockHttpServletRequest request = new MockHttpServletRequest();

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        ResponseEntity<UserDTO> responseEntity = usuarioRestController.createUser(userDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        UserDTO resultUserDTO = responseEntity.getBody();
        assertEquals(userDTO.getName(), resultUserDTO.getName());
        assertEquals(userDTO.getEmail(), resultUserDTO.getEmail());
    }

    @Test
    void getAllUserTest() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario();
        usuario1.setName("Manuel Fernando");
        usuario1.setEmail("msantofimio@serempre.com");
        usuarios.add(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setName("Luz Mary");
        usuario2.setEmail("ejemplo@ejemplo.com");
        usuarios.add(usuario2);

        when(userController.getAllUser()).thenReturn(usuarios);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        ResponseEntity<List<Usuario>> responseEntity = usuarioRestController.getAllUser();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Usuario> resultUsuarios = responseEntity.getBody();
        assertEquals(2, resultUsuarios.size());

        Usuario resultUsuario1 = resultUsuarios.get(0);
        assertEquals(usuario1.getName(), resultUsuario1.getName());
        assertEquals(usuario1.getEmail(), resultUsuario1.getEmail());

        Usuario resultUsuario2 = resultUsuarios.get(1);
        assertEquals(usuario2.getName(), resultUsuario2.getName());
        assertEquals(usuario2.getEmail(), resultUsuario2.getEmail());
    }
}