package com.myproject.demo.service;

import com.myproject.demo.domain.Orders;
import com.myproject.demo.repository.OrderRepository;
import com.myproject.demo.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    public Orders order(OrderRequest orderRequest) {
        Long memberId = orderRequest.getMemberId();
        Map<String, Integer> map = orderRequest.getMenu();
        log.info("menu {}{}",memberId, map);

        return null;
    }
}
