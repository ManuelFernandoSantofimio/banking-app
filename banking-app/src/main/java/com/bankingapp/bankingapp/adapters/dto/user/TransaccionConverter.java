package com.bankingapp.bankingapp.adapters.dto.user;

import com.bankingapp.bankingapp.domain.AbstractConverter;
import com.bankingapp.bankingapp.domain.entity.Transferencia;

public class TransaccionConverter extends AbstractConverter<Transferencia, TransaccionDTO> {

    @Override
    public Transferencia fromDto(TransaccionDTO dto) {
        Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigen(dto.getCuentaOrigen());
        transferencia.setCuentaDestino(dto.getCuentaDestino());
        transferencia.getMonto();
        return transferencia;
    }

    @Override
    public TransaccionDTO fromEntity(Transferencia entity) {
        TransaccionDTO transaccionDTO = new TransaccionDTO();
        transaccionDTO.setCuentaDestino(entity.getCuentaDestino());
        transaccionDTO.setCuentaOrigen(entity.getCuentaOrigen());
        transaccionDTO.setMonto(entity.getMonto());
        return transaccionDTO;
    }
}
