package com.daniyal.bankingsystem.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private User accountHolder;
}
