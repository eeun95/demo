package com.myproject.demo.controller;

import com.myproject.demo.domain.Orders;
import com.myproject.demo.request.OrderRequest;
import com.myproject.demo.response.OrderResponse;
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
    public ResponseEntity order(@RequestBody OrderRequest orderRequest) {
        Orders orders = orderService.order(orderRequest);
        OrderResponse response = new OrderResponse(orders);
        ResponseEntity pay = pointController.pay(response);
        return ResponseEntity.ok(pay);
    }

}
