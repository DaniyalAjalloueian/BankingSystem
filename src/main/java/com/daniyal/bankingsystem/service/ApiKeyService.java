package com.daniyal.bankingsystem.service;

import com.daniyal.bankingsystem.util.ApiKeyGenerator;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyService {
    public String createApiKey() {
        return ApiKeyGenerator.generateApiKey();
    }
}
