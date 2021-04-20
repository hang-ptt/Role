package com.hybrid.usermanagement.service;

import com.hybrid.usermanagement.dto.UserDto;
import com.hybrid.usermanagement.dto.mapper.UserMapper;
import com.hybrid.usermanagement.entity.Position;
import com.hybrid.usermanagement.entity.User;
import com.hybrid.usermanagement.repository.PositionRepository;
import com.hybrid.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    @Autowired
    PositionRepository positionRepository;

    public User assignPositin(long idUser, long idPosition){

        Position p = positionRepository.findByStatusAndId(true,idPosition);
        User user = userRepository.findByStatusAndId(true, idUser);
        List<Position> positions = user.getPositions();
        positions.add(p);
        userRepository.save(user);

        return user;
    }

    public List<User> getAll(){
        return userRepository.findByStatus(true);
    }

    public User getById(long id){
        return userRepository.findByStatusAndId(true,id);
//        return userMapper.toDataObject(userRepository.findByStatusAndId(true,id));
    }

}
