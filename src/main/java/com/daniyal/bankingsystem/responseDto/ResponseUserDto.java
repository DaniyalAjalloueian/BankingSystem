package com.daniyal.bankingsystem.responseDto;

public record ResponseUserDto(
        Long id,
        String firstName,
        String lastName,
        String userName
) {
}
