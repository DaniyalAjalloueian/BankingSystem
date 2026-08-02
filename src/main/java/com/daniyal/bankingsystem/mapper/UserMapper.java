package com.daniyal.bankingsystem.mapper;

import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.requestDto.RequestUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    RequestUserDto toDto(User user);

    User toEntity(RequestUserDto requestUserDto);
}
