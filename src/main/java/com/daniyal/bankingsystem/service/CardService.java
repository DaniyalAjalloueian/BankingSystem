package com.daniyal.bankingsystem.service;

import com.daniyal.bankingsystem.mapper.BankAccountMapper;
import com.daniyal.bankingsystem.mapper.CardMapper;
import com.daniyal.bankingsystem.model.BankAccount;
import com.daniyal.bankingsystem.model.Card;
import com.daniyal.bankingsystem.model.User;
import com.daniyal.bankingsystem.repository.CardRepository;
import com.daniyal.bankingsystem.responseDto.CardResponse;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    public CardService(CardMapper cardMapper,  CardRepository cardRepository) {
        this.cardMapper = cardMapper;
        this.cardRepository = cardRepository;
    }

    public CardResponse createCard(User user){
        Card card = new Card(user);
        cardRepository.save(card);
        return cardMapper.toDto(card);
    }
}
