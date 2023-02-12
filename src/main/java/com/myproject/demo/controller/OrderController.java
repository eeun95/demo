package com.myproject.demo.controller;

import com.myproject.demo.domain.Orders;
import com.myproject.demo.Dto.request.OrderRequestDto;
import com.myproject.demo.Dto.response.OrderResponseDto;
import com.myproject.demo.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final PointController pointController;

    @ApiOperation("커피 주문 API")
    @PostMapping("")
    public ResponseEntity order(@RequestBody OrderRequestDto orderRequestDto) {
        Orders orders = orderService.order(orderRequestDto);
        OrderResponseDto response = new OrderResponseDto(orders);

        ResponseEntity pay = pointController.pay(response);
        return ResponseEntity.ok(pay);
    }

}
