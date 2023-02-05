package com.myproject.demo.domain.Menu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coffee {
    @Id
    private Long id;
    private CoffeeCategory name;
    private int price;
    private boolean hot;
}
