package com.myproject.demo.repository;

import com.myproject.demo.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    @Query(value = "select coffee_name from receipt " +
            "where orders_id in " +
            "(select id from orders " +
            "where order_date between :before and :now) " +
            "group by coffee_name order by sum(count) limit 3;",
    nativeQuery = true)
    List showHotMenu(@Param("before") LocalDateTime before, @Param("now") LocalDateTime now);
}
