package com.myproject.demo.controller;

import com.myproject.demo.domain.Point;
import com.myproject.demo.Dto.request.PointRequestDto;
import com.myproject.demo.Dto.response.OrderResponseDto;
import com.myproject.demo.Dto.response.PointResponseDto;
import com.myproject.demo.service.PointService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @ApiOperation("포인트 충전 API")
    @PostMapping("")
    public ResponseEntity charge(PointRequestDto pointRequestDto) {
        Point point = pointService.charge(pointRequestDto);
        return ResponseEntity.ok(new PointResponseDto(point));
    }

    @ApiOperation("커피 결제 API")
    @GetMapping("/pay")
    public ResponseEntity pay(OrderResponseDto orderResponseDto) {
        Object obj = pointService.pay(orderResponseDto);
        Object response = obj;
        if(obj instanceof Point) {
            response = new PointResponseDto((Point) obj);
        }
        return ResponseEntity.ok(response);
    }
}
