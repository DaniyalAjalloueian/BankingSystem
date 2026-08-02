package com.daniyal.bankingsystem.requestDto;

import jakarta.validation.constraints.NotBlank;

public record RequestUserDto(
                      @NotBlank(message = "First Name can not be blank!") String firstName,
                      @NotBlank(message = "Last Name can not be blank!")String lastName,
                      @NotBlank(message = "User Name can not be blank!")String userName,
                      @NotBlank(message = "Password can not be blank!") String password
) {
}
