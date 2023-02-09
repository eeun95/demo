package com.myproject.demo.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id @GeneratedValue
    private Long id;

    private Long memberId;

    @OneToMany(mappedBy = "orders")
    private List<Receipt> receipts = new ArrayList<>();

    private int totalPrice;

    private LocalDateTime orderDate;
}
