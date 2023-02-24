package com.myproject.demo.domain.dto.response;

import com.myproject.demo.domain.entity.menu.Coffee;
import lombok.Data;

@Data
public class MenuResponseDto {
    private Long id;
    private String coffeeName;
    private int price;

    public MenuResponseDto(Coffee coffee) {
        this.id = coffee.getId();
        this.coffeeName = String.valueOf(coffee.getName());
        this.price = coffee.getPrice();
    }
}
