package com.daniyal.bankingsystem.service;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.daniyal.bankingsystem.exception.UserNotFound;
import com.daniyal.bankingsystem.exception.UsernameAlreadyExistsException;
import com.daniyal.bankingsystem.mapper.ApiKeyResponseMapper;
import com.daniyal.bankingsystem.mapper.RequestUserMapper;
import com.daniyal.bankingsystem.mapper.ResponseUserMapper;
import com.daniyal.bankingsystem.model.ApiKey;
import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.repository.UserRepository;
import com.daniyal.bankingsystem.requestDto.RequestUserDto;
import com.daniyal.bankingsystem.responseDto.ApiKeyResponse;
import com.daniyal.bankingsystem.responseDto.ResponseUserDto;
import com.daniyal.bankingsystem.responseDto.UserResponseWithApiKey;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ResponseUserMapper responseUserMapper;
    private final RequestUserMapper requestUserMapper;
    private final PasswordEncoder passwordEncoder;
    private final ApiKeyService  apiKeyService;
    private final ApiKeyResponseMapper apiKeyResponseMapper;


    public UserService(UserRepository userRepository, ResponseUserMapper responseUserMapper, RequestUserMapper requestUserMapper, PasswordEncoder passwordEncoder, ApiKeyService apiKeyService, ApiKeyResponseMapper apiKeyResponseMapper) {
        this.userRepository = userRepository;
        this.responseUserMapper = responseUserMapper;
        this.requestUserMapper = requestUserMapper;
        this.passwordEncoder = passwordEncoder;
        this.apiKeyService = apiKeyService;
        this.apiKeyResponseMapper = apiKeyResponseMapper;
    }

    public List<ResponseUserDto> findAll(){
        return userRepository.findAll().stream().map(responseUserMapper::toDto).toList();
    }

    public ResponseUserDto findById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User not found with id: " + id));
        return responseUserMapper.toDto(user);
    }

    public UserResponseWithApiKey saveUser(RequestUserDto requestUserDto) {

        if (userRepository.existsByUserName(requestUserDto.userName())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        User user = requestUserMapper.toEntity(requestUserDto);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        String key = apiKeyService.createApiKey();
        ApiKeyResponse apiKeyResponse = apiKeyResponseMapper.toApiKeyResponse(key);
        String encodedKey = passwordEncoder.encode(key);

        ApiKey apiKey = new ApiKey(encodedKey, true, user);

        user.setApiKey(apiKey);
        User savedUser = userRepository.save(user);
        ResponseUserDto responseUserDto = responseUserMapper.toDto(savedUser);
        return new UserResponseWithApiKey(responseUserDto,apiKeyResponse);
    }
}
