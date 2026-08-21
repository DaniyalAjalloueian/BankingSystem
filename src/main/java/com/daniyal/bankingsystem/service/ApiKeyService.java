//package com.daniyal.bankingsystem.service;
//
//import com.daniyal.bankingsystem.repository.ApiKeyRepository;
//import com.daniyal.bankingsystem.util.ApiKeyGenerator;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//@Service (disabled api key)
//public class ApiKeyService {
//    private final ApiKeyRepository apiKeyRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public ApiKeyService(ApiKeyRepository apiKeyRepository,  PasswordEncoder passwordEncoder) {
//        this.apiKeyRepository = apiKeyRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public String createApiKey() {
//        return ApiKeyGenerator.generateApiKey();
//    }
//
//    public boolean isValid(String rawApiKey) {
//
//        return apiKeyRepository.findByActiveTrue()
//                .stream()
//                .anyMatch(apiKey ->
//                        passwordEncoder.matches(
//                                rawApiKey,
//                                apiKey.getApiKey()
//                        )
//                );
//    }
//}
