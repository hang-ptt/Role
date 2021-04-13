package com.hybrid.usermanagement;

import com.hybrid.usermanagement.entity.Role;
import com.hybrid.usermanagement.entity.User;
import com.hybrid.usermanagement.repository.RoleRepository;
import com.hybrid.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UserManagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

}
