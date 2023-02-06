package com.myproject.demo.domain.Menu;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class Coffee {
    @Id @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private CoffeeCategory name;

    private int price;

    private boolean hot;
}
