package com.daniyal.bankingsystem.responseDto;

public record FullUserResponse(
        ResponseUserDto user ,
        BankAccountResponse bankAccount,
        CardResponse card
){
}
