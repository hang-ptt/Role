package com.hybrid.usermanagement.repository;

import com.hybrid.usermanagement.entity.Position;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {

    List<Position> findByStatus(boolean status);

    Position findByStatusAndId(boolean status, long id);

}
