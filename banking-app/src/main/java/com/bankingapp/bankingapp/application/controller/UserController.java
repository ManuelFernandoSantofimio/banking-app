package com.bankingapp.bankingapp.application.controller;

import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaConverter;
import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.dto.transaccion.TransaccionConverter;
import com.bankingapp.bankingapp.adapters.dto.transaccion.TransaccionDTO;
import com.bankingapp.bankingapp.adapters.dto.usuarios.UserConverter;
import com.bankingapp.bankingapp.adapters.dto.usuarios.UserDTO;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import com.bankingapp.bankingapp.domain.entity.Usuario;
import com.bankingapp.bankingapp.domain.repository.CuentaRepository;
import com.bankingapp.bankingapp.domain.repository.TransferenciaRepository;
import com.bankingapp.bankingapp.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {
    private final CuentaRepository cuentadb;
    private final UserRepository userdb;
    private final TransferenciaRepository transferenciadb;

    public UserController(CuentaRepository cuentadb, UserRepository userdb, TransferenciaRepository transferenciadb) {
        this.cuentadb = cuentadb;
        this.userdb = userdb;
        this.transferenciadb = transferenciadb;
    }

    public UserDTO createUser(Usuario usuario) {
        UserConverter converter = new UserConverter();
        Usuario savedUser = userdb.save(usuario);
        UserDTO userDTO = converter.fromEntity(savedUser);
        return userDTO;
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
        transferenciadb.save(transferencia);
        return transaccionDTO;
    }

    public List<Usuario> getAllUser() {
        UserConverter converter = new UserConverter();
        List<UserDTO> userDTO = converter.fromEntity(userdb.findAll());
        List<Usuario> x = userdb.findAll();
        return x;
    }
    public List<TransaccionDTO> getAllTransferencia() {
        TransaccionConverter converter = new TransaccionConverter();
        List<TransaccionDTO> transaccionDTO = converter.fromEntity(transferenciadb.findAll());

        return transaccionDTO;
    }

}
