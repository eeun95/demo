package com.myproject.demo.domain.Menu;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum CoffeeCategory {
    Americano,
    Latte,
    Coldbrew,
    Cappuccino,
    Espresso
}
