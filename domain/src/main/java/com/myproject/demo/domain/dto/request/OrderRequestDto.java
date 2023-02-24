package com.myproject.demo.domain.dto.request;

import lombok.Data;

import java.util.Map;

@Data
public class OrderRequestDto {
    private Long memberId;
    private Map<String, Integer> menu;
}
