package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.dto.cuenta.CuentaDTO;
import com.bankingapp.bankingapp.adapters.dto.transaccion.TransaccionDTO;
import com.bankingapp.bankingapp.application.controller.UserController;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/transferencia")
public class TransferenciaRestController {
    private final UserController userController;

    public TransferenciaRestController(UserController userController) {
        this.userController = userController;
    }


    @PostMapping
    public ResponseEntity<TransaccionDTO> transferencia(@RequestBody Transferencia transferencia){
        TransaccionDTO transaccionDTO = userController.transferencia(transferencia);
        return ResponseEntity.status(200)
                .body(transaccionDTO);
    }

    @GetMapping
    public ResponseEntity<List<TransaccionDTO>> getAllTransferencia(){
        List<TransaccionDTO> transaccionDTO = userController.getAllTransferencia();
        return ResponseEntity.status(200)
                .body(transaccionDTO);
    }
}
