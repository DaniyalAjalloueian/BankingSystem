package com.daniyal.bankingsystem.service;

import com.daniyal.bankingsystem.exception.UserNotFound;
import com.daniyal.bankingsystem.mapper.ResponseUserMapper;
import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.repository.UserRepository;
import com.daniyal.bankingsystem.responseDto.ResponseUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ResponseUserMapper responseUserMapper;

    public UserService(UserRepository userRepository, ResponseUserMapper responseUserMapper) {
        this.userRepository = userRepository;
        this.responseUserMapper = responseUserMapper;
    }

    public List<ResponseUserDto> findAll(){
        return userRepository.findAll().stream().map(responseUserMapper::toDto).toList();
    }

    public ResponseUserDto findById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User not found with id: " + id));
        return responseUserMapper.toDto(user);
    }
}
