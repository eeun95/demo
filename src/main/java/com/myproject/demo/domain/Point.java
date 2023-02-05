package com.myproject.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Point {
    @Id
    private Long id;
    private Long memberId;
    private int point;
}
