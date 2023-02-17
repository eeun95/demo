package com.myproject.demo.service;

import com.myproject.demo.Dto.request.OrderRequestDto;
import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Orders;
import com.myproject.demo.domain.Receipt;
import com.myproject.demo.repository.MenuRepository;
import com.myproject.demo.repository.OrderRepository;
import com.myproject.demo.repository.Receipt.ReceiptRepository;
import io.github.classgraph.HasName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    ReceiptRepository receiptRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void 메뉴_주문() {

        Map<String, Integer> menu = new HashMap<>();
        menu.put("Americano", 2);
        menu.put("Latte", 2);

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setMemberId(1L);
        orderRequestDto.setMenu(menu);

        Long memberId = orderRequestDto.getMemberId();
        Map<String, Integer> map = orderRequestDto.getMenu();

        Orders orders = Orders.builder()
                .memberId(memberId)
                .orderDate(LocalDateTime.now())
                .build();

        List<Coffee> coffeeList = menuRepository.findAll();

        Map<String, Integer> priceList = new HashMap<>();
        for (Coffee coffee : coffeeList) {
            priceList.put(String.valueOf(coffee.getName()), coffee.getPrice());
        }

        int totalPrice = 0;
        for (String coffeeName : map.keySet()) {
            int price = priceList.get(coffeeName)*map.get(coffeeName);
            totalPrice += price;
            Receipt receipt = Receipt.builder()
                    .orders(orders)
                    .coffeeName(coffeeName)
                    .count(map.get(coffeeName))
                    .price(price)
                    .build();
            receiptRepository.save(receipt);
            orders.setReceipts(receipt);
        }
        orders.setTotalPrice(totalPrice);
        Orders saveOrders = orderRepository.save(orders);

        //log.info("receipt {}", saveOrders.getReceipts());

    }
}