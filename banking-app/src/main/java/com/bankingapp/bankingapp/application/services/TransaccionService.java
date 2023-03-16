package com.bankingapp.bankingapp.application.services;

import com.bankingapp.bankingapp.adapters.inbound.dto.transferencia.TransaccionConverter;
import com.bankingapp.bankingapp.adapters.inbound.dto.transferencia.TransaccionDTO;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import com.bankingapp.bankingapp.domain.repository.CuentaRepository;
import com.bankingapp.bankingapp.domain.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {
    private final CuentaRepository cuentadb;
    private final TransferenciaRepository transferenciadb;

    public TransaccionService(CuentaRepository cuentadb, TransferenciaRepository transferenciadb) {
        this.cuentadb = cuentadb;
        this.transferenciadb = transferenciadb;
    }

    public List<Transferencia> getAll() {
        return transferenciadb.findAll();
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
