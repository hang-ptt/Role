package com.hybrid.usermanagement.controller;

import com.hybrid.usermanagement.entity.Role;
import com.hybrid.usermanagement.entity.User;
import com.hybrid.usermanagement.repository.RoleRepository;
import com.hybrid.usermanagement.repository.UserRepository;
import com.hybrid.usermanagement.request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class CRUDController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @GetMapping()
    public String showAllUser(Model model){
        List<User> users= userRepository.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String viewUserDetail(@PathVariable("id")Long id, Model model){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        model.addAttribute("user",user);
        return "detail";
    }

    @DeleteMapping("/delete/{id}")
    public String deteleUser(@PathVariable("id") Long id, Model model){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        userRepository.deleteById(id);
        model.addAttribute("user",user);
        return "index";
    }
    @PutMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid @ModelAttribute AddUserRequest addUserRequest){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        Set<String> strRoles = addUserRequest.getRole();
        Set<Role> roles = new HashSet<>();

        user.setRoles(roles);
        userRepository.save(user);

        return "index";
    }

}
