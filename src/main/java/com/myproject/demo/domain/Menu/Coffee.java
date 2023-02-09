package com.myproject.demo.domain.Menu;

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
public class Coffee {
    @Id @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private CoffeeCategory name;

    private int price;

    private boolean hot;
}
