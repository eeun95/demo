package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.repository.MenuRepository;
import com.myproject.demo.repository.Receipt.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService implements MenuServiceInterface {

    private final MenuRepository menuRepository;

    private final ReceiptRepository receiptRepository;

    public List<Coffee> show() {
        return menuRepository.findAll();
    }

    public List<String> hot() {
        List<String> coffeeList = receiptRepository.showHotMenu(LocalDateTime.now().minusDays(7), LocalDateTime.now());
        log.info("hotMenu {}", coffeeList);
        return coffeeList;
    }

    public Map<String, Integer> getMenuPrice() {
        List<Coffee> coffeeList = menuRepository.findAll();

        Map<String, Integer> priceList = new HashMap<>();
        for (Coffee coffee : coffeeList) {
            priceList.put(String.valueOf(coffee.getName()), coffee.getPrice());
        }
        log.info("menu {}{}",priceList, coffeeList);
        return priceList;
    }
}
