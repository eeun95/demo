package com.myproject.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {
    @Id
    private Long id;
    //private Map<String, Integer> receipt = new HashMap<>();
    private int price;
}
