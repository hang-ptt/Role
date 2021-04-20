package com.hybrid.usermanagement.service;

import com.hybrid.usermanagement.entity.Position;
import com.hybrid.usermanagement.entity.PositionSubject;
import com.hybrid.usermanagement.entity.Subject;
import com.hybrid.usermanagement.repository.PositionRepository;
import com.hybrid.usermanagement.repository.PositionSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Autowired
    PositionSubjectRepository positionSubjectRepository;

    @Autowired SubjectService subjectService;

    @Transactional
    public Position create(Position position){

        position.setCreatedAt(new Date());

        position.getPositionSubjects().forEach(ps->{
            ps.setStatus(true);
            ps.setCreatedAt(new Date());
        });

        position.setStatus(true);

        Position p = positionRepository.save(position);

        position.getPositionSubjects().forEach(ps->{
            ps.setPosition(p);
            positionSubjectRepository.save(ps);
        });
        return p;
    }

    public List<Position> getAll(){
        return positionRepository.findByStatus(true);
    }

    public Position getById(long id){
        return positionRepository.findByStatusAndId(true,id);
    }

    public boolean remove(long id){
        try{
            Position p = positionRepository.findByStatusAndId(true,id);
            p.setStatus(false);
            positionRepository.save(p);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Position getEmptyOne(){
        Position pos = new Position();

        List<Subject> subjects = subjectService.getAll();
        List<PositionSubject> positionSubjects = new ArrayList<>();

        subjects.forEach(sub->{
            PositionSubject ps = PositionSubject.builder().subject(sub).allowCreate(false).allowEdit(false).allowView(false).allowDelete(false).build();
            positionSubjects.add(ps);
        });

        pos.setPositionSubjects(positionSubjects);

        return pos;
    }
}
