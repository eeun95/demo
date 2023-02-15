package com.myproject.demo.service;

import com.myproject.demo.Dto.request.PointRequestDto;
import com.myproject.demo.Dto.response.OrderResponseDto;
import com.myproject.demo.domain.Point;

public interface PointServiceInterface {

    Point charge(PointRequestDto pointRequestDto);

    Point pay(OrderResponseDto orderResponseDto);
}
