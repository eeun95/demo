package com.myproject.demo.controller;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.service.MenuService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @ApiOperation("커피 메뉴 목록 조회 API")
    @GetMapping("/show")
    public ResponseEntity show() {
        List<Coffee> response = menuService.show();
        return ResponseEntity.ok(null);
    }

    @ApiOperation("인기메뉴 목록 조회 API")
    @GetMapping("/hot")
    public ResponseEntity hot() {

        return ResponseEntity.ok(null);
    }
}
