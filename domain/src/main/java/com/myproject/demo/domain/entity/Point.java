package com.myproject.demo.domain.entity;

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
public class Point {
    @Id @GeneratedValue
    private Long id;

    private Long memberId;

    private int totalPoint;

    public void updatePoint(int point) {
        this.totalPoint = point;
    }
}
