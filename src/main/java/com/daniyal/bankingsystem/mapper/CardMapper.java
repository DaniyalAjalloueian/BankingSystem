package com.daniyal.bankingsystem.mapper;

import com.daniyal.bankingsystem.model.Card;
import com.daniyal.bankingsystem.responseDto.CardResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardResponse toDto(Card card);
}
