package com.daniyal.bankingsystem.repository;

import com.daniyal.bankingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
