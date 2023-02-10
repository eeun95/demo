package com.myproject.demo.repository;

import com.myproject.demo.domain.Menu.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Coffee, Long> {

    List<Coffee> findAll();
}
