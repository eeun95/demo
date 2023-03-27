package com.myproject.demo.application.service;

import com.myproject.demo.domain.dto.presentation.OrderServiceDto;
import com.myproject.demo.domain.entity.Orders;
import com.myproject.demo.domain.entity.Receipt;
import com.myproject.demo.domain.repository.OrderRepository;
import com.myproject.demo.domain.repository.RedisRepository;
import com.myproject.demo.domain.repository.receipt.ReceiptRepository;
import com.myproject.demo.domain.dto.request.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderServiceInterface {
    private final OrderRepository orderRepository;

    private final ReceiptRepository receiptRepository;

    private final RedisRepository redisRepository;

    public Orders order(OrderServiceDto orderRequestDto,
                        Map<String, Integer> priceList) {
        Long memberId = orderRequestDto.getMemberId();
        Map<String, Integer> map = orderRequestDto.getMenu();

        Orders orders = Orders.builder()
                .memberId(memberId)
                .orderDate(LocalDateTime.now())
                .build();

        int totalPrice = 0;
        for (String coffeeName : map.keySet()) {
            int price = priceList.get(coffeeName) * map.get(coffeeName);
            totalPrice += price;
            Receipt receipt = Receipt.builder()
                    .orders(orders)
                    .coffeeName(coffeeName)
                    .count(map.get(coffeeName))
                    .price(price)
                    .build();
            receiptRepository.save(receipt);
            // redis 에 저장
            int redisCount = redisRepository.getScore("hot", coffeeName);
            redisRepository.saveRedis(coffeeName, map.get(coffeeName)+redisCount);
            orders.setReceipts(receipt);
        }
        orders.setTotalPrice(totalPrice);
        Orders saveOrders = orderRepository.save(orders);

        //log.info("receipt {}", saveOrders.getReceipts());
        return saveOrders;
    }
}
