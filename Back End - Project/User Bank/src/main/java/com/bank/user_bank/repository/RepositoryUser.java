package com.bank.user_bank.repository;

import com.bank.user_bank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUser extends JpaRepository<User, Long> {

}
