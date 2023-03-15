package com.bankingapp.bankingapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterfaceService extends JpaRepository<User, Long> {
}
