package com.hybrid.usermanagement.controller;

import com.hybrid.usermanagement.security.RoleRepository;
import com.hybrid.usermanagement.security.Account;
import com.hybrid.usermanagement.security.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CRUDController {
    @Autowired
    AccountRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/user")
    public String showAllUser(Model model){
        List<Account> users= userRepository.findAll();
        model.addAttribute("users", users);
        return "user";
    }

//    @GetMapping("/detail/{id}")
//    public String viewUserDetail(@PathVariable("id")Long id, Model model){
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
//        model.addAttribute("user",user);
//        return "detail";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deteleUser(@PathVariable("id") Long id, Model model){
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
//        userRepository.deleteById(id);
//        model.addAttribute("user",user);
//        return "index";
//    }
//    @PutMapping("/edit/{id}")
//    public String updateUser(@PathVariable("id") Long id, @Valid @ModelAttribute AddUserRequest addUserRequest){
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
//        Set<String> strRoles = addUserRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        user.setRoles(roles);
//        userRepository.save(user);
//
//        return "index";
//    }

}
