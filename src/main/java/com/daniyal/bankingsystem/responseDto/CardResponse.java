package com.daniyal.bankingsystem.responseDto;

public record CardResponse (String cardNumber,
                            String cvv2,
                            String expiryYear,
                            String expiryMonth){
}
