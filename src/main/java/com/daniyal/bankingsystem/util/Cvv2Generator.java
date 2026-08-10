package com.daniyal.bankingsystem.util;

import java.security.SecureRandom;

public final class Cvv2Generator {

    private static final SecureRandom RANDOM = new SecureRandom();

    private Cvv2Generator() {
    }

    public static String generate() {
        return String.format("%03d", RANDOM.nextInt(1000));
    }
}