package com.daniyal.bankingsystem.responseDto;

import com.daniyal.bankingsystem.mapper.ResponseUserMapper;

public record UserResponseWithApiKey (ResponseUserDto user , ApiKeyResponse apiKeyResponse){
}
