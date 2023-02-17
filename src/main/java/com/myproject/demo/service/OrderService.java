package com.myproject.demo.service;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Orders;
import com.myproject.demo.domain.Receipt;
import com.myproject.demo.repository.MenuRepository;
import com.myproject.demo.repository.OrderRepository;
import com.myproject.demo.repository.Receipt.ReceiptRepository;
import com.myproject.demo.Dto.request.OrderRequestDto;
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
public class OrderService implements OrderServiceInterface{
    private final OrderRepository orderRepository;

    private final ReceiptRepository receiptRepository;

    private final MenuRepository menuRepository;

    public Orders order(OrderRequestDto orderRequestDto) {
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
        log.info("menu {}{}",priceList, coffeeList);

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
        return saveOrders;
    }
}
