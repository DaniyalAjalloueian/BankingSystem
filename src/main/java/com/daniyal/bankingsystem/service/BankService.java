package com.daniyal.bankingsystem.service;

import com.daniyal.bankingsystem.mapper.BankAccountMapper;
import com.daniyal.bankingsystem.model.BankAccount;
import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.repository.BankAccountRepository;
import com.daniyal.bankingsystem.responseDto.BankAccountResponse;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper  bankAccountMapper;
    public BankService(BankAccountRepository bankAccountRepository , BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }

    public BankAccountResponse createBankAccount(User accountHolder){
        BankAccount bankAccount = new BankAccount(accountHolder);
        accountHolder.setBankAccount(bankAccount);
        bankAccountRepository.save(bankAccount);
        return bankAccountMapper.toDto(bankAccount);
    }
}
