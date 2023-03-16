package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.inbound.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.inbound.dto.transferencia.TransaccionDTO;
import com.bankingapp.bankingapp.application.controller.bankController;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/cuenta")
public class CuentaRestController {
    private final bankController userController;

    public CuentaRestController(bankController userController) {
        this.userController = userController;
    }

    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuentas(){
        List<Cuenta> userdto = userController.getAllCuentas();
        return ResponseEntity.status(200)
                .body(userdto);
    }
    @PostMapping
    public ResponseEntity<CuentaDTO> createCuenta(){
        CuentaDTO userdto = userController.createCuenta();
        return ResponseEntity.status(200)
                .body(userdto);
    }
}
