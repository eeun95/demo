package com.myproject.demo.response;

import com.myproject.demo.domain.Point;
import lombok.Data;

@Data
public class PointResponse {
    private Long memberId;
    private int totalPoint;

    public PointResponse(Point point) {
        this.memberId = point.getMemberId();
        this.totalPoint = point.getTotalPoint();
    }
}
