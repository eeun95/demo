package com.myproject.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Point {
    @Id @GeneratedValue
    private Long id;

    private Long memberId;

    private int point;
}
