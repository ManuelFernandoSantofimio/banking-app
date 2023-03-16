package com.bankingapp.bankingapp.application.controller;

import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaConverter;
import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Usuario;
import com.bankingapp.bankingapp.domain.repository.CuentaRepository;
import com.bankingapp.bankingapp.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Controller
public class CuentaController {
    private final CuentaRepository cuentadb;
    private final UserRepository userdb;

    public CuentaController(CuentaRepository cuentadb, UserRepository userdb) {
        this.cuentadb = cuentadb;
        this.userdb = userdb;
    }

    public List<CuentaDTO> getAllCuentas() {
        CuentaConverter converter = new CuentaConverter();
        List<CuentaDTO> userDTO = converter.fromEntity(cuentadb.findAll());
        List<Cuenta> x = cuentadb.findAll();

        return userDTO;
    }


    public CuentaDTO createCuenta(Long id) {
        Usuario user = userdb.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        CuentaConverter converter = new CuentaConverter();

        Cuenta cuenta = new Cuenta();
        Random random = new Random();

        int numAleatorio = random.nextInt(900000000) + 100000000;
        cuenta.setNumero(String.valueOf(numAleatorio));

        cuenta.setSaldo(BigDecimal.TEN);
        cuenta.setUsuario(user);
        cuentadb.save(cuenta);
        userdb.save(user);
        CuentaDTO cuentaDTO = converter.fromEntity(cuenta);
        return cuentaDTO;
    }

}
