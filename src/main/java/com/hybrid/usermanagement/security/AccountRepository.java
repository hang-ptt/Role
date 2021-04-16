package com.hybrid.usermanagement.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByName(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    List<Account> findAll();

    Account getAccountByName(String name);
}
