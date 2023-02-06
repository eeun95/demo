package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Menu.CoffeeCategory;
import com.myproject.demo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<Coffee> show() {
        menuRepository.save(Coffee.builder()
                .name(CoffeeCategory.Americano)
                .price(4500)
                .build());
        menuRepository.save(Coffee.builder()
                .name(CoffeeCategory.Cappuccino)
                .price(5000)
                .build());
        menuRepository.save(Coffee.builder()
                .name(CoffeeCategory.Coldbrew)
                .price(5500)
                .build());
        menuRepository.save(Coffee.builder()
                .name(CoffeeCategory.Latte)
                .price(5000)
                .build());
        menuRepository.save(Coffee.builder()
                .name(CoffeeCategory.Espresso)
                .price(3000)
                .build());
        return menuRepository.findAll();
    }
}
