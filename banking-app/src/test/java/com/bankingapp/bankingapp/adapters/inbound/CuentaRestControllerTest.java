package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.dto.transaccion.TransaccionDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CuentaRestControllerTest {
    private CuentaRestController cuentaRestController;
    private UserController userControllerMock;

    @BeforeEach
    public void setUp() {
        userControllerMock = Mockito.mock(UserController.class);
        cuentaRestController = new CuentaRestController(userControllerMock);
    }

    @Test
    void getAllCuentas() {
        List<CuentaDTO> cuentas = new ArrayList<>();

        Mockito.when(userControllerMock.getAllCuentas()).thenReturn(cuentas);
        ResponseEntity<List<CuentaDTO>> response = cuentaRestController.getAllCuentas();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cuentas, response.getBody());
    }

    @Test
    void createCuenta() {
        CuentaDTO cuentaDTO = new CuentaDTO();

        Mockito.when(userControllerMock.createCuenta(cuentaDTO.getId())).thenReturn(cuentaDTO);
        ResponseEntity<CuentaDTO> response = cuentaRestController.createCuenta(cuentaDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cuentaDTO, response.getBody());
    }
}