package com.myproject.demo.domain.dto.response;

import com.myproject.demo.domain.entity.Orders;
import com.myproject.demo.domain.entity.Receipt;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OrderResponseDto {
    private Long memberId;
    private Map<String, Integer> receipt;
    private int totalPrice;
    private LocalDateTime orderDate;

    public OrderResponseDto(Orders order) {
        this.memberId = order.getMemberId();
        this.receipt = makeReceipt(order.getReceipts());
        this.totalPrice = order.getTotalPrice();
        this.orderDate = order.getOrderDate();
    }

    public Map<String, Integer> makeReceipt(List<Receipt> receipt) {
        Map<String, Integer> map = new HashMap<>();
        for (Receipt r : receipt) {
            map.put(r.getCoffeeName(), r.getCount());
        }
        return map;
    }
}
