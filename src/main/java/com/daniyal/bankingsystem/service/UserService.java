package com.daniyal.bankingsystem.service;

import com.daniyal.bankingsystem.exception.UserNotFound;
import com.daniyal.bankingsystem.exception.UsernameAlreadyExistsException;
import com.daniyal.bankingsystem.mapper.BankAccountMapper;
import com.daniyal.bankingsystem.mapper.RequestUserMapper;
import com.daniyal.bankingsystem.mapper.ResponseUserMapper;
import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.repository.UserRepository;
import com.daniyal.bankingsystem.requestDto.RequestUserDto;
import com.daniyal.bankingsystem.responseDto.BankAccountResponse;
import com.daniyal.bankingsystem.responseDto.CardResponse;
import com.daniyal.bankingsystem.responseDto.ResponseUserDto;
import com.daniyal.bankingsystem.responseDto.FullUserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ResponseUserMapper responseUserMapper;
    private final RequestUserMapper requestUserMapper;
    private final PasswordEncoder passwordEncoder;
    private final BankService bankService;
    private final CardService cardService;


    public UserService(UserRepository userRepository, ResponseUserMapper responseUserMapper, RequestUserMapper requestUserMapper, PasswordEncoder passwordEncoder,  BankService bankService,  CardService cardService) {
        this.userRepository = userRepository;
        this.responseUserMapper = responseUserMapper;
        this.requestUserMapper = requestUserMapper;
        this.passwordEncoder = passwordEncoder;
        this.bankService = bankService;
        this.cardService = cardService;
    }

    public List<ResponseUserDto> findAll(){
        return userRepository.findAll().stream().map(responseUserMapper::toDto).toList();
    }

    public ResponseUserDto findById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User not found with id: " + id));
        return responseUserMapper.toDto(user);
    }

    public FullUserResponse saveUser(RequestUserDto requestUserDto) {

        if (userRepository.existsByUserName(requestUserDto.userName())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        User user = requestUserMapper.toEntity(requestUserDto);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        String key = apiKeyService.createApiKey();
//        ApiKeyResponse apiKeyResponse = apiKeyResponseMapper.toApiKeyResponse(key);
//        String encodedKey = passwordEncoder.encode(key);

//        ApiKey apiKey = new ApiKey(encodedKey, true, user);

//        user.setApiKey(apiKey);

        User savedUser = userRepository.save(user);
        BankAccountResponse bankAccountResponse = bankService.createBankAccount(user);
        CardResponse cardResponse = cardService.createCard(user);
        userRepository.save(savedUser);


        ResponseUserDto responseUserDto = responseUserMapper.toDto(savedUser);

        return new FullUserResponse(responseUserDto, bankAccountResponse, cardResponse);
    }
}
