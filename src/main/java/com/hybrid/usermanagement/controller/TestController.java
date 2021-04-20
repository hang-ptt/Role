package com.hybrid.usermanagement.controller;

import com.hybrid.usermanagement.entity.User;
import com.hybrid.usermanagement.repository.UserRepository;
import com.hybrid.usermanagement.service.PositionService;
import com.hybrid.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/blank")
public class TestController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PositionService positionService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping("")
    public String showListOfUsers(Model model) {

        model.addAttribute("data", userRepository.findAll());

        return "blank";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id")long id) {
        return userService.getById(id);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest req, User users, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {

        String basePath = req.getServletContext().getRealPath("/directory");
        File folder = new File(basePath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String fileName = file.getOriginalFilename();
        String filePath = basePath +"/"+ fileName;


        if(fileName != null && fileName.length() > 0) {
            File fileServer = new File(filePath);

            try {
                //save file
                file.transferTo(fileServer);
                //save file infor
                users.setFiles("/directory/"+fileName);
                Date date = new Date();
                users.setCreatedAt(date);
                users.setUpdatedAt(date);
                userRepository.save(users);
            } catch (IllegalStateException | IOException e) {
                return "redirect:/blank?msg=error";
            }
        }

        userRepository.save(users);
        return "redirect:/blank";
    }
    @GetMapping("/edit")
    @ResponseBody
    public Optional<User> update(Long id) {
        logger.info("User has been updated. Users id: " + id);
        return userRepository.findById(id);
    }
    @GetMapping("/delete")
    public String delete(Long id) {
        userRepository.deleteById(id);
        logger.info("User has been removed. Users id: " + id);
        return "redirect:/blank";
    }

    @GetMapping("/assign")
    public String viewAssignPosition(Model model){

        model.addAttribute("users", userService.getAll());
        model.addAttribute("positions", positionService.getAll());

        return "assign";
    }

    @PostMapping("/assign/handle")
    public String handleAssignUser(@RequestParam(name = "userId")long userId, @RequestParam(name = "positionId")long positionId){
        userService.assignPositin(userId,positionId);
        return "redirect:/user/assign";
    }
}
