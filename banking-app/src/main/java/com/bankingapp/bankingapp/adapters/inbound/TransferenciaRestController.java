package com.bankingapp.bankingapp.adapters.inbound;

import com.bankingapp.bankingapp.adapters.inbound.dto.transferencia.TransaccionDTO;
import com.bankingapp.bankingapp.application.controller.bankController;
import com.bankingapp.bankingapp.domain.entity.Cuenta;
import com.bankingapp.bankingapp.domain.entity.Transferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/transferencia")
public class TransferenciaRestController {
    private final bankController userController;

    public TransferenciaRestController(bankController userController) {
        this.userController = userController;
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> getAllTransferencias(){
        List<Transferencia> userdto = userController.getAllTransferencias();
        return ResponseEntity.status(200)
                .body(userdto);
    }
    @PostMapping
    public ResponseEntity<TransaccionDTO> transferencia(@RequestBody Transferencia transferencia){
        TransaccionDTO transaccionDTO = userController.transferencia(transferencia);
        return ResponseEntity.status(200)
                .body(transaccionDTO);
    }
}
