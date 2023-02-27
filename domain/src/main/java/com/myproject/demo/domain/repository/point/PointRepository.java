package com.myproject.demo.domain.repository.point;

import com.myproject.demo.domain.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    Point save(Point point);

    Optional<Point> findByMemberId(Long MemberId);
}
