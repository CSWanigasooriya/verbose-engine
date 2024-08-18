package com.engine.verbose.accountsmanager.repository;


import com.engine.verbose.accountsmanager.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {
    Optional<Bank> findByCode(String code);

    Optional<Bank> findByName(String name);
}