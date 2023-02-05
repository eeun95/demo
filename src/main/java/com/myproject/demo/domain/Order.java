package com.myproject.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Order {
    @Id
    private Long id;
    //private Map<String, Integer> receipt = new HashMap<>();
    private int price;
}
