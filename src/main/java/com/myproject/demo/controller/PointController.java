package com.myproject.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
public class PointController {

    @ApiOperation("포인트 충전 API")
    public ResponseEntity charge() {
        return ResponseEntity.ok(null);
    }
}
