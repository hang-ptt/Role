package com.hybrid.usermanagement.controller;

import com.hybrid.usermanagement.entity.Role;
import com.hybrid.usermanagement.entity.User;
import com.hybrid.usermanagement.repository.RoleRepository;
import com.hybrid.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class IntiUser {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        Set<Role> roles = new HashSet<>();roles.add(roleRepository.getByName("ROLE_ADMIN"));
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
