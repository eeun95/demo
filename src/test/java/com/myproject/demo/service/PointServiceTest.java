package com.myproject.demo.service;

import com.myproject.demo.Dto.request.OrderRequestDto;
import com.myproject.demo.Dto.request.PointRequestDto;
import com.myproject.demo.Exception.LackOfPointException;
import com.myproject.demo.Exception.MemberNotFoundException;
import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Orders;
import com.myproject.demo.domain.Point;
import com.myproject.demo.domain.PointHistory;
import com.myproject.demo.repository.MenuRepository;
import com.myproject.demo.repository.point.PointHistoryRepository;
import com.myproject.demo.repository.point.PointRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PointServiceTest {

    @Autowired
    PointRepository pointRepository;

    @Autowired
    PointHistoryRepository pointHistoryRepository;

    @Autowired
    MenuRepository menuRepository;

    @Test
    void 포인트_충전() {
        PointRequestDto pointRequestDto = new PointRequestDto();
        pointRequestDto.setMemberId(1L);
        pointRequestDto.setPoint(10000);

        Long memberId = pointRequestDto.getMemberId();
        Optional<Point> point = pointRepository.findByMemberId(memberId);

        Point p = null;
        if (point.isEmpty()) {

            p = Point.builder()
                    .memberId(memberId)
                    .totalPoint(pointRequestDto.getPoint())
                    .build();

        } else {
            p = point.get();
            p.updatePoint(p.getTotalPoint()+ pointRequestDto.getPoint());
        }

        Point savePoint = pointRepository.save(p);

        pointHistoryRepository.save(PointHistory.builder()
                .point(p)
                .chargePoint(pointRequestDto.getPoint())
                .build());
    }

    @Test
    void 포인트_사용() {

        Map<String, Integer> menu = new HashMap<>();
        menu.put("Americano", 2);
        menu.put("Latte", 2);

        Orders orders = Orders.builder()
                .memberId(1L)
                .orderDate(LocalDateTime.now())
                .build();

        List<Coffee> coffeeList = menuRepository.findAll();

        Map<String, Integer> priceList = new HashMap<>();
        for (Coffee coffee : coffeeList) {
            priceList.put(String.valueOf(coffee.getName()), coffee.getPrice());
        }
    }
}