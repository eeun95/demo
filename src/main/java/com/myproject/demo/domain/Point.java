package com.myproject.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
