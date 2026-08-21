package com.daniyal.bankingsystem.util;

import com.daniyal.bankingsystem.responseDto.ExpiryDate;

import java.security.SecureRandom;
import java.time.LocalDate;

public final class CardGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String generateCardNumber() {
        StringBuilder cardNumber = new StringBuilder("6037");

        for (int i = 0; i < 12; i++) {
            cardNumber.append(random.nextInt(10));
        }

        return cardNumber.toString();
    }

    public static String generateCVV2() {
        return String.format("%04d", random.nextInt(10000));
    }

    public static ExpiryDate generateExpiryYearAndMonth(){

        LocalDate expiryDate = LocalDate.now().plusYears(5);
        return new ExpiryDate(
                String.valueOf(expiryDate.getYear() % 100),
                String.format("%02d", expiryDate.getMonthValue())
        );
    }
}