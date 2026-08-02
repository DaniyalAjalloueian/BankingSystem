package com.daniyal.bankingsystem.controller;

import com.daniyal.bankingsystem.responseDto.ResponseUserDto;
import com.daniyal.bankingsystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
