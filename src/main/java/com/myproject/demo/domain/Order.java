package com.myproject.demo.domain;

import jakarta.persistence.Entity;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Order {
    private Long id;
    private Map<String, Integer> receipt = new HashMap<>();
    private int price;
}
