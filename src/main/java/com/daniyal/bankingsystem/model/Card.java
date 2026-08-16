package com.daniyal.bankingsystem.model;

import com.daniyal.bankingsystem.responseDto.ExpiryDate;
import com.daniyal.bankingsystem.util.CardGenerator;
import jakarta.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 16)
    private String cardNumber;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private BankAccount bankAccount;

    @Column(nullable = false, length = 3)
    private String cvv2;

    @Column(nullable = false)
    private String expiryMonth;

    @Column(nullable = false)
    private String expiryYear;

    public Card() {
    }

    public Card(User user) {
        ExpiryDate expiryDate = CardGenerator.generateExpiryYearAndMonth();
        this.bankAccount = user.getBankAccount();
        this.cardNumber = CardGenerator.generateCardNumber();
        this.cvv2 = CardGenerator.generateCVV2();
        this.expiryYear = expiryDate.year();
        this.expiryMonth = expiryDate.month();

    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }
}