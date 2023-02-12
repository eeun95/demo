package com.myproject.demo.Dto.response;

import com.myproject.demo.domain.Point;
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
