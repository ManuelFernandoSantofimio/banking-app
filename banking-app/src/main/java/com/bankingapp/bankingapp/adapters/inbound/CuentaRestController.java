package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.dto.transaccion.TransaccionDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/cuenta")
public class CuentaRestController {
    private final UserController userController;

    public CuentaRestController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping
    public ResponseEntity<List<CuentaDTO>> getAllCuentas(){
        List<CuentaDTO> userdto = userController.getAllCuentas();
        return ResponseEntity.status(200)
                .body(userdto);
    }
    @PostMapping
    public ResponseEntity<CuentaDTO> createCuenta(@RequestBody CuentaDTO cuentaDTO){
        CuentaDTO userdto = userController.createCuenta(cuentaDTO.getId());
        return ResponseEntity.status(200)
                .body(userdto);
    }
    @PostMapping("/transferencia")
    public ResponseEntity<TransaccionDTO> transferencia(@RequestBody Transferencia transferencia){
        TransaccionDTO transaccionDTO = userController.transferencia(transferencia);
        return ResponseEntity.status(200)
                .body(transaccionDTO);
    }
}
