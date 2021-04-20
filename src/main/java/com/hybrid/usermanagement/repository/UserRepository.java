package com.hybrid.usermanagement.repository;


import com.hybrid.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByStatusAndId(boolean status, long id);

    List<User> findByStatus(boolean status);
}
