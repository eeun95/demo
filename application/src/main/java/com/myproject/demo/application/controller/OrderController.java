package com.myproject.demo.application.controller;

import com.myproject.demo.domain.dto.response.PointResponseDto;
import com.myproject.demo.domain.entity.Orders;
import com.myproject.demo.domain.dto.request.OrderRequestDto;
import com.myproject.demo.domain.dto.response.OrderResponseDto;
import com.myproject.demo.application.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    private final PointController pointController;

    private final MenuController menuController;

    @ApiOperation("커피 주문 API")
    @PostMapping("")
    public PointResponseDto order(@RequestBody OrderRequestDto orderRequestDto) {
        Orders orders = orderService.order(orderRequestDto, menuController.getMenuPrice());
        OrderResponseDto response = new OrderResponseDto(orders);

        PointResponseDto pointResponseDto = pointController.pay(response);
        return pointResponseDto;
    }

}
