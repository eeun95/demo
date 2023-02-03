package com.myproject.demo.domain;

import jakarta.persistence.Entity;

@Entity
public class Point {
    private Long id;
    private Long memberId;
    private int point;
}
