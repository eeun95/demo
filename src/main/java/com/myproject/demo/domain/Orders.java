package com.myproject.demo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id @GeneratedValue
    private Long id;

    private Long memberId;

    @ManyToOne
    @JoinColumn(name="RECEIPT_ID")
    private Receipt receipt;

    private int totalPrice;
}
