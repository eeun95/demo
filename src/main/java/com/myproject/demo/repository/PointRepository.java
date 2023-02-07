package com.myproject.demo.repository;

import com.myproject.demo.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    Point save(Point point);
    Optional<Point> findByMemberId(Long MemberId);
}
