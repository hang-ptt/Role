package com.hybrid.usermanagement.repository;

import com.hybrid.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    List<User> findAll();
}
