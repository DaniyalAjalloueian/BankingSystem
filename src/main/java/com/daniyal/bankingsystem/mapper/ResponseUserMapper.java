package com.daniyal.bankingsystem.mapper;

import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.responseDto.ResponseUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseUserMapper {
    ResponseUserDto toDto(User user);
}
