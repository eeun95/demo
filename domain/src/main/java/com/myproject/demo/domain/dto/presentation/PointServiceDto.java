package com.myproject.demo.domain.dto.presentation;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter
public class PointServiceDto {

    private Long memberId;

    private int point;

    private Map<String, Integer> receipt;

    private int totalPrice;

    private LocalDateTime orderDate;


}
