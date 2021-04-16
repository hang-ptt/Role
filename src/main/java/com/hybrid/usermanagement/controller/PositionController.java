package com.hybrid.usermanagement.controller;

import com.hybrid.usermanagement.entity.Location;
import com.hybrid.usermanagement.entity.Position;
import com.hybrid.usermanagement.entity.PositionSubject;
import com.hybrid.usermanagement.entity.Subject;
import com.hybrid.usermanagement.repository.LocationRepository;
import com.hybrid.usermanagement.repository.PositionRepository;
import com.hybrid.usermanagement.repository.SubjectRepository;
import com.hybrid.usermanagement.security.Account;
import com.hybrid.usermanagement.security.AccountRepository;
import com.hybrid.usermanagement.security.UserDetailsImpl;
import com.hybrid.usermanagement.security.UserDetailsServiceImpl;
import com.hybrid.usermanagement.service.LocationService;
import com.hybrid.usermanagement.service.PositionService;
import com.hybrid.usermanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pos")
public class PositionController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    PositionService positionService;

    @Autowired
    LocationService locationService;


    @GetMapping()
    public String viewListPosition(Model model){
        List<Position> positions = positionService.getAll();
        model.addAttribute("positions", positions);
        return "list-position";
    }

    @GetMapping("/add")
    public String viewAddPosition(Model model){

//        Create new position
        Position pos = new Position();

        List<Subject> subjects = subjectService.getAll();
        List<PositionSubject> positionSubjects = new ArrayList<>();

        subjects.forEach(sub->{
            PositionSubject ps = PositionSubject.builder().subject(sub).allowCreate(false).allowEdit(false).allowView(false).allowDelete(false).build();
            positionSubjects.add(ps);
        });

        pos.setPositionSubjects(positionSubjects);

        model.addAttribute("locations", locationService.getAll());
        model.addAttribute("position",pos);

        return "position";
    }

    @GetMapping("/edit/{id}")
    public String viewEditPosition(Model model, @PathVariable(name = "id")long id){

        Position position = positionService.getById(id);

        model.addAttribute("locations", locationService.getAll());
        model.addAttribute("position",position);

        return "position";
    }

    @PostMapping("/add/handle")
    public String handleAddPosition(@ModelAttribute("position") Position position){
        try{
            position.setCreatedAt(new Date());

            position.getPositionSubjects().forEach(ps->{
                ps.setStatus(true);
                ps.setCreatedAt(new Date());
            });

            position.setStatus(true);

            positionService.create(position);
            return "redirect:/pos";
        }
        catch (Exception e){
            return "redirect:/pos?msg=error";
        }
    }

    @RequestMapping("/delete/{id}")
    public String removePosition(@PathVariable(name = "id") long id){
        positionService.remove(id);
        return "redirect:/pos";
    }

}
