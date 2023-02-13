package com.myproject.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
public class Orders {

    @Builder
    public Orders(Long memberId, LocalDateTime orderDate) {
        this.memberId = memberId;
        this.receipts = new ArrayList<>();
        this.orderDate = orderDate;
    }

    @Id @GeneratedValue
    private Long id;

    private Long memberId;

    @Builder.Default
    @OneToMany(mappedBy = "orders")
    private List<Receipt> receipts = new ArrayList<>();

    private int totalPrice;

    private LocalDateTime orderDate;

    public void setTotalPrice(int amount) {
        this.totalPrice = amount;
    }
    public void setReceipts(Receipt receipt) {
        getReceipts().add(receipt);
    }
}
