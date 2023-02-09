package com.myproject.demo.domain.Menu;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Coffee {
    @Id @GeneratedValue
    private Long id;

    private CoffeeCategory name;

    private int price;

    private boolean hot;
}
