package com.bankingapp.bankingapp.adapters.dto.cuenta;

import com.bankingapp.bankingapp.domain.AbstractConverter;
import com.bankingapp.bankingapp.domain.entity.Cuenta;

public class CuentaConverter extends AbstractConverter<Cuenta, CuentaDTO> {

    @Override
    public Cuenta fromDto(CuentaDTO dto) {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumero(dto.getNumero());
        cuenta.setSaldo(dto.getSaldo());
        return cuenta;
    }

    @Override
    public CuentaDTO fromEntity(Cuenta entity) {
        CuentaDTO cuenta = new CuentaDTO();
        cuenta.setNumero(entity.getNumero());
        cuenta.setSaldo(entity.getSaldo());
        return cuenta;
    }
}
