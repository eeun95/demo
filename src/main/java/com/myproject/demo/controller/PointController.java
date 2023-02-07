package com.myproject.demo.controller;

import com.myproject.demo.domain.Point;
import com.myproject.demo.request.PointRequest;
import com.myproject.demo.service.PointService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.ok(null);
    }
}
