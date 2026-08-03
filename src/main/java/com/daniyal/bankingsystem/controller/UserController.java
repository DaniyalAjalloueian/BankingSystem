package com.daniyal.bankingsystem.controller;

import com.daniyal.bankingsystem.requestDto.RequestUserDto;
import com.daniyal.bankingsystem.responseDto.ResponseUserDto;
import com.daniyal.bankingsystem.responseDto.UserResponseWithApiKey;
import com.daniyal.bankingsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<ResponseUserDto> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseUserDto findUserById(@PathVariable long id){
        return userService.findById(id);
    }

    @PostMapping
    public UserResponseWithApiKey saveUSer(@RequestBody RequestUserDto requestUserDto){
        return userService.saveUser(requestUserDto);
    }
}
