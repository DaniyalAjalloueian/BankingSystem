package com.daniyal.bankingsystem.mapper;

import com.daniyal.bankingsystem.model.ApiKey;
import com.daniyal.bankingsystem.responseDto.ApiKeyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiKeyResponseMapper {
    ApiKeyResponse toApiKeyResponse(ApiKey apiKey);
}
