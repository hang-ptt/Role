package com.hybrid.usermanagement.service;

import com.hybrid.usermanagement.entity.Position;
import com.hybrid.usermanagement.repository.PositionRepository;
import com.hybrid.usermanagement.repository.PositionSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Autowired
    PositionSubjectRepository positionSubjectRepository;

    @Transactional
    public Position create(Position position){
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
}
