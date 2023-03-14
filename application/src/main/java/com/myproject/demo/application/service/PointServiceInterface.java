package com.myproject.demo.application.service;

import com.myproject.demo.domain.dto.presentation.PointServiceDto;
import com.myproject.demo.domain.dto.request.PointRequestDto;
import com.myproject.demo.domain.dto.response.OrderResponseDto;
import com.myproject.demo.domain.entity.Point;

public interface PointServiceInterface {

    Point charge(PointServiceDto pointRequestDto);

    Point pay(PointServiceDto orderResponseDto);
}
