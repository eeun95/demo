package com.myproject.demo.controller;

import com.myproject.demo.Exception.ExceptionResponse;
import com.myproject.demo.domain.Point;
import com.myproject.demo.request.PointRequest;
import com.myproject.demo.response.OrderResponse;
import com.myproject.demo.response.PointResponse;
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
    public ResponseEntity charge(PointRequest pointRequest) {
        Point point = pointService.charge(pointRequest);
        return ResponseEntity.ok(new PointResponse(point));
    }

    @ApiOperation("커피 결제 API")
    @GetMapping("/pay")
    public ResponseEntity pay(OrderResponse orderResponse) {
        Object obj = pointService.pay(orderResponse.getMemberId(), orderResponse.getTotalPrice());
        Object response = obj;
        if(obj instanceof Point) {
            response = new PointResponse((Point) obj);
        }
        return ResponseEntity.ok(response);
    }
}
