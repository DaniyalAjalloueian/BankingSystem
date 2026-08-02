package com.daniyal.bankingsystem.service;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.daniyal.bankingsystem.exception.UserNotFound;
import com.daniyal.bankingsystem.exception.UsernameAlreadyExistsException;
import com.daniyal.bankingsystem.mapper.RequestUserMapper;
import com.daniyal.bankingsystem.mapper.ResponseUserMapper;
import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.repository.UserRepository;
import com.daniyal.bankingsystem.requestDto.RequestUserDto;
import com.daniyal.bankingsystem.responseDto.ResponseUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ResponseUserMapper responseUserMapper;
    private final RequestUserMapper requestUserMapper;

    public UserService(UserRepository userRepository, ResponseUserMapper responseUserMapper, RequestUserMapper requestUserMapper) {
        this.userRepository = userRepository;
        this.responseUserMapper = responseUserMapper;
        this.requestUserMapper = requestUserMapper;
    }

    public List<ResponseUserDto> findAll(){
        return userRepository.findAll().stream().map(responseUserMapper::toDto).toList();
    }

    public ResponseUserDto findById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User not found with id: " + id));
        return responseUserMapper.toDto(user);
    }

    public ResponseUserDto saveUser(RequestUserDto requestUserDto) {

        if (userRepository.existsByUserName(requestUserDto.userName())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        User user = requestUserMapper.toEntity(requestUserDto);

        User savedUser = userRepository.save(user);

        return responseUserMapper.toDto(savedUser);
    }
}
