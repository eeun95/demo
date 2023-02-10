package com.myproject.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
@Table(name="point_history")
public class PointHistory {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="POINT_HISTORY_ID")
    private Point point;

    private int chargePoint;

    private int usePoint;
}
