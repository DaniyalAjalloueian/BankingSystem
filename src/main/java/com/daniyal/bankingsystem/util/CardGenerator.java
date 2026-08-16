package com.daniyal.bankingsystem.util;

import java.security.SecureRandom;

public final class CardGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String generateCardNumber() {
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }

        return cardNumber.toString();
    }

    public static String generateCVV2() {
        return String.format("%04d", random.nextInt(10000));
    }
}