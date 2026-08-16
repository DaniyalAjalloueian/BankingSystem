package com.daniyal.bankingsystem.repository;

import com.daniyal.bankingsystem.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
