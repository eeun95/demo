package com.myproject.demo.service;

import com.myproject.demo.Exception.ErrorCode;
import com.myproject.demo.Exception.ExceptionResponse;
import com.myproject.demo.Exception.LackOfPointException;
import com.myproject.demo.Exception.MemberNotFoundException;
import com.myproject.demo.domain.Point;
import com.myproject.demo.domain.PointHistory;
import com.myproject.demo.repository.point.PointHistoryRepository;
import com.myproject.demo.repository.point.PointRepository;
import com.myproject.demo.Dto.request.PointRequestDto;
import com.myproject.demo.Dto.response.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PointService implements PointServiceInterface{

    private final PointRepository pointRepository;

    private final PointHistoryRepository pointHistoryRepository;

    public Point charge(PointRequestDto pointRequestDto) {
        Long memberId = pointRequestDto.getMemberId();
        Optional<Point> point = pointRepository.findByMemberId(memberId);

        Point p = null;
        if (point.isEmpty()) {

            p = Point.builder()
                    .memberId(memberId)
                    .totalPoint(pointRequestDto.getPoint())
                    .build();

        } else {
            p = point.get();
            p.updatePoint(p.getTotalPoint()+ pointRequestDto.getPoint());
        }

        Point savePoint = pointRepository.save(p);

        pointHistoryRepository.save(PointHistory.builder()
                .point(p)
                .chargePoint(pointRequestDto.getPoint())
                .build());

        return savePoint;
    }

    public Point pay(OrderResponseDto orderResponseDto) {
        Long memberId = orderResponseDto.getMemberId();
        int totalPrice = orderResponseDto.getTotalPrice();
        Optional<Point> pointObj = pointRepository.findByMemberId(memberId);

        if(pointObj.isEmpty()) {
            throw new MemberNotFoundException();
        } else {
            Point memberPoint = pointObj.get();
            if (memberPoint.getTotalPoint() < totalPrice) {
                throw new LackOfPointException();
            } else {
                int remainPoint = memberPoint.getTotalPoint() - totalPrice;
                log.info("remainPoint {}", remainPoint);
                memberPoint.updatePoint(remainPoint);
                pointRepository.save(memberPoint);

                pointHistoryRepository.save(PointHistory.builder()
                        .point(memberPoint)
                        .usePoint(totalPrice)
                        .build());
                return memberPoint;
            }
        }
    }
}
