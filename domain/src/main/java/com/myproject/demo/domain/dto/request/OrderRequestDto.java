package com.myproject.demo.domain.dto.request;

import com.myproject.demo.domain.dto.presentation.OrderServiceDto;
import lombok.Data;

import java.util.Map;

@Data
public class OrderRequestDto {
    private Long memberId;
    private Map<String, Integer> menu;

    public OrderServiceDto toServiceDto() {
        return OrderServiceDto.builder()
                .memberId(this.memberId)
                .menu(this.menu)
                .build();
    }
}
