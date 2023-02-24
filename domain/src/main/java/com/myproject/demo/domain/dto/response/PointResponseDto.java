package com.myproject.demo.domain.dto.response;

import com.myproject.demo.domain.entity.Point;
import lombok.Data;

@Data
public class PointResponseDto {
    private Long memberId;
    private int totalPoint;

    public PointResponseDto(Point point) {
        this.memberId = point.getMemberId();
        this.totalPoint = point.getTotalPoint();
    }
}
