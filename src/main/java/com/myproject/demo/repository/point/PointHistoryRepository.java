package com.myproject.demo.repository.point;

import com.myproject.demo.domain.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistory, Long> {

    PointHistory save(PointHistory pointHistory);

}
