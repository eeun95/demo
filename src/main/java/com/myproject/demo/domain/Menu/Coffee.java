package com.myproject.demo.domain.Menu;

import jakarta.persistence.Entity;

@Entity
public class Coffee {
    private Long id;
    private CoffeeCategory name;
    private int price;
    private boolean hot;
}
