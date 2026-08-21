package com.daniyal.bankingsystem.mapper;

import com.daniyal.bankingsystem.model.BankAccount;
import com.daniyal.bankingsystem.responseDto.BankAccountResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccountResponse toDto(BankAccount bankAccount);
}
