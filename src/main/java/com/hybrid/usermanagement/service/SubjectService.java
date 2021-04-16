package com.hybrid.usermanagement.service;

import com.hybrid.usermanagement.entity.Subject;
import com.hybrid.usermanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAll(){
        return subjectRepository.findByStatus(true);
    }
}
