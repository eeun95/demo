package com.myproject.demo.domain;

import jakarta.persistence.*;

@Entity
public class Receipt {
    @Id @GeneratedValue
    private Long id;

    private Long orderId;

    private String coffeeName;
    
    private int count;

    private int price;
}
