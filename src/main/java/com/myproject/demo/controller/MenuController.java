package com.myproject.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @ApiOperation("커피 메뉴 목록 조회 API")
    @GetMapping("/show")
    public ResponseEntity show() {

        return ResponseEntity.ok(null);
    }

    @ApiOperation("인기메뉴 목록 조회 API")
    @GetMapping("/hot")
    public ResponseEntity hot() {

        return ResponseEntity.ok(null);
    }
}
