package com.bank.softway.repository;

import com.bank.softway.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInterfaceUser extends JpaRepository<User, Long> {

}
