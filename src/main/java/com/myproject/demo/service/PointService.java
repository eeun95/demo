package com.myproject.demo.service;

import com.myproject.demo.domain.Point;
import com.myproject.demo.domain.PointHistory;
import com.myproject.demo.repository.PointHistoryRepository;
import com.myproject.demo.repository.PointRepository;
import com.myproject.demo.request.PointRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PointService {

    private final PointRepository pointRepository;

    private final PointHistoryRepository pointHistoryRepository;

    public Point charge(PointRequest pointRequest) {
        Long memberId = pointRequest.getMemberId();
        Optional<Point> point = pointRepository.findByMemberId(memberId);

        log.info("request {}", pointRequest);
        Point p = null;
        if (point.isEmpty()) {

            p = Point.builder()
                    .memberId(memberId)
                    .totalPoint(pointRequest.getPoint())
                    .build();

        } else {
            p = point.get();
            p.updatePoint(pointRequest.getPoint());
        }

        Point savePoint = pointRepository.save(p);

        pointHistoryRepository.save(PointHistory.builder()
                .point(p)
                .chargePoint(pointRequest.getPoint())
                .build());

        return savePoint;
    }
}
