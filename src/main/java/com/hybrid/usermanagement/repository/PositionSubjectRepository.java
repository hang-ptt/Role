package com.hybrid.usermanagement.repository;

import com.hybrid.usermanagement.entity.PositionSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionSubjectRepository extends JpaRepository<PositionSubject, Long> {
}
