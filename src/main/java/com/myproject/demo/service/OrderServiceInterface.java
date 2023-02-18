package com.myproject.demo.service;

import com.myproject.demo.Dto.request.OrderRequestDto;
import com.myproject.demo.domain.Orders;

import java.util.Map;

public interface OrderServiceInterface {

    Orders order(OrderRequestDto orderRequestDto, Map<String, Integer> coffeeList);
}
