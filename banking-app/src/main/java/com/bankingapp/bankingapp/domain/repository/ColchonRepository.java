package com.bankingapp.bankingapp.domain.repository;

import com.bankingapp.bankingapp.domain.entity.Colchon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColchonRepository extends JpaRepository<Colchon, Long> {
}
