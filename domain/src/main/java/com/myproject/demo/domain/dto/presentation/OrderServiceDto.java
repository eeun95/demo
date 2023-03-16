package com.myproject.demo.domain.dto.presentation;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class OrderServiceDto {
    private Long memberId;
    private Map<String, Integer> menu;
}
