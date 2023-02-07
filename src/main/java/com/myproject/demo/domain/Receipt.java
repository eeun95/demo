package com.myproject.demo.domain;

import jakarta.persistence.*;

@Entity
public class Receipt {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="ORDERS_ID")
    private Orders orders;

    private String coffeeName;

    private int count;

    private int price;
}
