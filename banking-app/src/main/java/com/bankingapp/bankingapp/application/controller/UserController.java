package com.bankingapp.bankingapp.application.controller;

import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaConverter;
import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.dto.user.TransaccionConverter;
import com.bankingapp.bankingapp.adapters.dto.user.TransaccionDTO;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import com.bankingapp.bankingapp.domain.repository.CuentaRepository;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {
    private final CuentaRepository cuentadb;

    public UserController(CuentaRepository cuentadb) {
        this.cuentadb = cuentadb;
    }


    public List<Cuenta> getAllCuentas() {
        CuentaConverter converter = new CuentaConverter();
        List<CuentaDTO> userDTO = converter.fromEntity(cuentadb.findAll());
        List<Cuenta> x = cuentadb.findAll();

        return x;
    }


    public CuentaDTO createCuenta() {
        CuentaConverter converter = new CuentaConverter();

        Cuenta cuenta = new Cuenta();
        Random random = new Random();

        int numAleatorio = random.nextInt(900000000) + 100000000;
        cuenta.setNumero(String.valueOf(numAleatorio));

        cuenta.setSaldo(BigDecimal.ZERO);
        cuenta =  cuentadb.save(cuenta);
        CuentaDTO cuentaDTO = converter.fromEntity(cuenta);
        return cuentaDTO;
    }


    public TransaccionDTO transferencia(Transferencia transferencia) {
        TransaccionConverter converter = new TransaccionConverter();
        TransaccionDTO transaccionDTO = converter.fromEntity(transferencia);

        Cuenta origen = cuentadb.findById(transaccionDTO.getCuentaOrigen()).orElseThrow();
        Cuenta destino = cuentadb.findById(transaccionDTO.getCuentaDestino()).orElseThrow();

        origen.setSaldo(origen.getSaldo().subtract(transaccionDTO.getMonto()));
        destino.setSaldo(destino.getSaldo().add(transaccionDTO.getMonto()));
        cuentadb.save(origen);
        cuentadb.save(destino);
        return transaccionDTO;
    }

}
