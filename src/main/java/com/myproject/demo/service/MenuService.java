package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;
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
        return menuRepository.findAll();
    }

    public List<String> hot() {
        List<String> coffeeList = receiptRepository.showHotMenu(LocalDateTime.now().minusDays(7), LocalDateTime.now());
        log.info("hotMenu {}", coffeeList);
        return coffeeList;
    }
}
