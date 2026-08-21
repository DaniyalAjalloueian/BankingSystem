package com.daniyal.bankingsystem.responseDto;

import java.math.BigDecimal;

public record BankAccountResponse(Long id,
                                  BigDecimal balance) {
}
