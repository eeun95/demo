package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Menu.CoffeeCategory;
import com.myproject.demo.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuServiceTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    void 커피_메뉴_조회() {
        List<Coffee> coffeeList = menuRepository.findAll();
    }

    @Test
    void 인기_메뉴_조회() {

    }
}