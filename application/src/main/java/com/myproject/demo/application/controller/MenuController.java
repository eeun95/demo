package com.myproject.demo.application.controller;

import com.myproject.demo.domain.entity.menu.Coffee;
import com.myproject.demo.domain.dto.response.MenuResponseDto;
import com.myproject.demo.application.service.MenuService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @ApiOperation("커피 메뉴 목록 조회 API")
    @GetMapping("")
    public List<MenuResponseDto> show() {
        List<Coffee> coffeeList = menuService.show();
        List<MenuResponseDto> response = new ArrayList<>();
        for (Coffee c : coffeeList) {
            response.add(new MenuResponseDto(c));
        }
        return response;
    }

    @ApiOperation("인기메뉴 목록 조회 API")
    @GetMapping("/hot7")
    public List<String> hot7() {
        return menuService.hot();
    }

    @ApiOperation("인기메뉴 목록 조회 API")
    @GetMapping("/hot")
    public List<String> hot() {
        return menuService.hot();
    }

    public Map<String, Integer> getMenuPrice() {
        return menuService.getMenuPrice();
    }
}
