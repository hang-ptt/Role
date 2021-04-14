package com.hybrid.usermanagement.controller;

import com.hybrid.usermanagement.security.RoleRepository;
import com.hybrid.usermanagement.security.AccountRepository;
import com.hybrid.usermanagement.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

//    @PostMapping("/addUser")
//    public String addUser(@Valid @ModelAttribute AddUserRequest addUserRequest){
//
//
////        if (userRepository.existsByName(addUserRequest.getUsername())) {
////            return "Error: Username is already in use!";
////        }
////
////        if (userRepository.existsByEmail(addUserRequest.getEmail())) {
////            return "Error: Email is already in use!";
////        }
//        // Create new user's account
//        User user = new User(addUserRequest.getUsername(),
//                addUserRequest.getEmail(),
//                passwordEncoder.encode(addUserRequest.getPassword()));
//
//        Set<String> strRoles = addUserRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null) {
//            Role userRole = roleRepository.findByName("ROLE_USER")
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(adminRole);
//
//                        break;
//                    case "mod":
//                        Role modRole = roleRepository.findByName("ROLE_MODERATOR")
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName("ROLE_USER")
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(userRole);
//                }
//            });
//        }
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//
//        return "login";
//    }

    @GetMapping(value = "/home")
    public String index(){
        return "home";
    }
    @GetMapping(value = {"/"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
