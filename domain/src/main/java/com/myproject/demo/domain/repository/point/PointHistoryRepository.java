package com.myproject.demo.domain.repository.point;

import com.myproject.demo.domain.entity.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistory, Long> {

    PointHistory save(PointHistory pointHistory);

}
