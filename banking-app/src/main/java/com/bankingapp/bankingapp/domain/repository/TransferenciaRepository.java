package com.bankingapp.bankingapp.domain.repository;

import com.bankingapp.bankingapp.domain.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
