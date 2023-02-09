package com.myproject.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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