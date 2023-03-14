package com.myproject.demo.application.controller;

import com.myproject.demo.application.exception.MemberNotFoundException;
import com.myproject.demo.application.service.PointService;
import com.myproject.demo.domain.dto.request.PointRequestDto;
import com.myproject.demo.domain.dto.response.OrderResponseDto;
import com.myproject.demo.domain.dto.response.PointResponseDto;
import com.myproject.demo.domain.entity.Point;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
@Slf4j
public class PointController {

    private final PointService pointService;

    @GetMapping("")
    public void test() {
        throw new MemberNotFoundException();
    }

    @ApiOperation("포인트 충전 API")
    @PostMapping("")
    public PointResponseDto charge(@RequestBody PointRequestDto pointRequestDto) {
        Point point = pointService.charge(pointRequestDto.toServiceDto());
        return new PointResponseDto(point);
    }

    @ApiOperation("커피 결제 API")
    @GetMapping("/pay")
    public PointResponseDto pay(OrderResponseDto orderResponseDto) {
        Point point = pointService.pay(orderResponseDto.toServiceDto());
        return new PointResponseDto(point);
    }
}
