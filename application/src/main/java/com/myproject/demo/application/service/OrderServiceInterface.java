package com.myproject.demo.application.service;

import com.myproject.demo.domain.dto.request.OrderRequestDto;
import com.myproject.demo.domain.entity.Orders;

import java.util.Map;

public interface OrderServiceInterface {

    Orders order(OrderRequestDto orderRequestDto, Map<String, Integer> coffeeList);
}
