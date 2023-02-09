package com.myproject.demo.response;

import com.myproject.demo.domain.Menu.Coffee;
import lombok.Data;

@Data
public class MenuResponse {
    private Long id;
    private String coffeeName;
    private int price;

    public MenuResponse(Coffee coffee) {
        this.id = coffee.getId();
        this.coffeeName = String.valueOf(coffee.getName());
        this.price = coffee.getPrice();
    }
}
