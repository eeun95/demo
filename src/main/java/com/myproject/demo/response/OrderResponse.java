package com.myproject.demo.response;

import com.myproject.demo.domain.Orders;
import com.myproject.demo.domain.Receipt;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OrderResponse {
    private Long memberId;
    private Map<String, Integer> receipt;
    private int totalPrice;
    private LocalDateTime orderDate;

    public OrderResponse(Orders order) {
        this.memberId = order.getMemberId();
        this.receipt = makeReceipt(order.getReceipts());
        this.totalPrice = order.getTotalPrice();
        this.orderDate = order.getOrderDate();
    }

    public Map<String, Integer> makeReceipt(List<Receipt> receipt) {
        Map<String, Integer> map = new HashMap<>();
        for(Receipt r : receipt) {
            map.put(r.getCoffeeName(), r.getCount());
        }
        return map;
    }
}
