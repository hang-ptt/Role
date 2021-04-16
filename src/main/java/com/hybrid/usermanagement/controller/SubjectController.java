package com.hybrid.usermanagement.controller;

import com.hybrid.usermanagement.entity.Subject;
import com.hybrid.usermanagement.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
    @GetMapping("")
    public String showListOfUsers(Model model) {

        model.addAttribute("data", subjectRepository.findAll());

        return "subject";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Subject sub) {
        Date date = new Date();
        sub.setCreatedAt(date);
        sub.setUpdatedAt(date);
        subjectRepository.save(sub);
        logger.info("New user was created " + sub);
        return "redirect:/subject";
    }

    @GetMapping("/edit")
    @ResponseBody
    public Optional<Subject> update(Long id) {
        logger.info("User has been updated. Users id: " + id);
        return subjectRepository.findById(id);
    }
    @GetMapping("/delete")
    public String delete(Long id) {
        subjectRepository.deleteById(id);
        logger.info("User has been removed. Users id: " + id);
        return "redirect:/subject";
    }

}
