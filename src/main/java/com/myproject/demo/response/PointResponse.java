package com.myproject.demo.response;

import com.myproject.demo.domain.Point;

public class PointResponse {
    private Long id;
    private Long memberId;
    private int totalPoint;

    public PointResponse(Point point) {
        this.id = point.getId();
        this.memberId = point.getMemberId();
        this.totalPoint = point.getTotalPoint();
    }
}
