package com.myproject.demo.controller;

import com.myproject.demo.Dto.response.PointResponseDto;
import com.myproject.demo.Exception.ErrorCode;
import com.myproject.demo.Exception.ExceptionResponse;
import com.myproject.demo.Exception.MemberNotFoundException;
import com.myproject.demo.domain.Orders;
import com.myproject.demo.Dto.request.OrderRequestDto;
import com.myproject.demo.Dto.response.OrderResponseDto;
import com.myproject.demo.domain.Point;
import com.myproject.demo.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
