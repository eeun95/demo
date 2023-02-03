package com.myproject.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @ApiOperation("커피 주문 API")
    public ResponseEntity order() {

        return ResponseEntity.ok(null);
    }

    @ApiOperation("커피 결제 API")
    @GetMapping("/pay")
    public ResponseEntity pay() {

        return ResponseEntity.ok(null);
    }


}
