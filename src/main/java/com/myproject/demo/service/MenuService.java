package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Menu.CoffeeCategory;
import com.myproject.demo.domain.Receipt;
import com.myproject.demo.repository.MenuRepository;
import com.myproject.demo.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;

    private final ReceiptRepository receiptRepository;

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

    public List<String> hot() {
        List<String> coffeeList = receiptRepository.showHotMenu(LocalDateTime.now().minusDays(7), LocalDateTime.now());
        log.info("hotMenu {}", coffeeList);
        return coffeeList;
    }
}
