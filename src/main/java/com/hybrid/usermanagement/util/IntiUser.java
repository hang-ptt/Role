package com.hybrid.usermanagement.util;

import com.hybrid.usermanagement.entity.Subject;
import com.hybrid.usermanagement.repository.SubjectRepository;
import com.hybrid.usermanagement.security.Role;
import com.hybrid.usermanagement.security.RoleRepository;
import com.hybrid.usermanagement.security.Account;
import com.hybrid.usermanagement.security.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Controller
public class IntiUser {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AccountRepository userRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<Account> create(@RequestBody Account user){
        Set<Role> roles = new HashSet<>();roles.add(roleRepository.getByName("ROLE_ADMIN"));
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/mock/pos/create")
    public ResponseEntity<Subject> create(@RequestBody Subject sub){
        sub.setStatus(true);
        subjectRepository.save(sub);
        return new ResponseEntity<>(sub, HttpStatus.OK);
    }

    @RequestMapping("/blank")
    public String blank(){return "blank";}
}
