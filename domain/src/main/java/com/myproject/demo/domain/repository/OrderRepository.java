package com.myproject.demo.domain.repository;

import com.myproject.demo.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
