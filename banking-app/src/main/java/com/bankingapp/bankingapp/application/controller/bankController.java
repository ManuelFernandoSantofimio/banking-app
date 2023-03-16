package com.bankingapp.bankingapp.application.controller;

import com.bankingapp.bankingapp.adapters.inbound.dto.cuenta.CuentaConverter;
import com.bankingapp.bankingapp.adapters.inbound.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.inbound.dto.transferencia.TransaccionConverter;
import com.bankingapp.bankingapp.adapters.inbound.dto.transferencia.TransaccionDTO;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import com.bankingapp.bankingapp.domain.repository.CuentaRepository;
import com.bankingapp.bankingapp.domain.repository.TransferenciaRepository;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Controller
public class bankController {
    private final CuentaRepository cuentadb;
    private final TransferenciaRepository transferenciadb;

    public bankController(CuentaRepository cuentadb, TransferenciaRepository transferenciaRepository) {
        this.cuentadb = cuentadb;
        this.transferenciadb = transferenciaRepository;
    }


    public List<Cuenta> getAllCuentas() {
        CuentaConverter converter = new CuentaConverter();
        List<CuentaDTO> userDTO = converter.fromEntity(cuentadb.findAll());
        List<Cuenta> x = cuentadb.findAll();

        return x;
    }
    public List<Transferencia> getAllTransferencias() {
        CuentaConverter converter = new CuentaConverter();

        List<Transferencia> x = transferenciadb.findAll();

        return x;
    }


    public CuentaDTO createCuenta() {
        CuentaConverter converter = new CuentaConverter();

        Cuenta cuenta = new Cuenta();
        Random random = new Random();

        int numAleatorio = random.nextInt(900000000) + 100000000;
        cuenta.setNumero(String.valueOf(numAleatorio));

        cuenta.setSaldo(BigDecimal.TEN);
        cuenta =  cuentadb.save(cuenta);
        CuentaDTO cuentaDTO = converter.fromEntity(cuenta);
        return cuentaDTO;
    }


    public TransaccionDTO transferencia(Transferencia transferencia) {
        TransaccionConverter converter = new TransaccionConverter();
        TransaccionDTO transaccionDTO = converter.fromEntity(transferencia);

        Cuenta origen = cuentadb.findById(transaccionDTO.getCuentaOrigen()).orElseThrow();
        Cuenta destino = cuentadb.findById(transaccionDTO.getCuentaDestino()).orElseThrow();

        if (origen.getSaldo().compareTo(transaccionDTO.getMonto()) < 0) {
            throw new IllegalArgumentException("No tienes suficiente dinero");
        }
        origen.setSaldo(origen.getSaldo().subtract(transaccionDTO.getMonto()));
        destino.setSaldo(destino.getSaldo().add(transaccionDTO.getMonto()));
        cuentadb.save(origen);
        cuentadb.save(destino);
        transferenciadb.save(transferencia);
        return transaccionDTO;
    }

}
