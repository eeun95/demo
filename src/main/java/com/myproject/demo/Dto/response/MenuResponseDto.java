package com.myproject.demo.Dto.response;

import com.myproject.demo.domain.Menu.Coffee;
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
