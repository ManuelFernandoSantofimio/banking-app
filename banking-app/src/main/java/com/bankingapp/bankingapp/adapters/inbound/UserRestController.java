package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.dto.user.TransaccionDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/cuenta")
    public ResponseEntity<List<Cuenta>> getAllCuentas(){
        List<Cuenta> userdto = userController.getAllCuentas();
        return ResponseEntity.status(200)
                .body(userdto);
    }
    @PostMapping("/cuenta")
    public ResponseEntity<CuentaDTO> createCuenta(){
        CuentaDTO userdto = userController.createCuenta();
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
