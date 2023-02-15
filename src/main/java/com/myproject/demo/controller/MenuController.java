package com.myproject.demo.controller;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.Dto.response.MenuResponseDto;
import com.myproject.demo.service.MenuService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/hot")
    public List<String> hot() {
        return menuService.hot();
    }
}
