package com.myproject.demo.domain.dto.request;

import com.myproject.demo.domain.dto.presentation.PointServiceDto;
import lombok.Data;

@Data
public class PointRequestDto {
    private Long memberId;
    private int point;

    public PointServiceDto toServiceDto() {
        return PointServiceDto.builder()
                .memberId(this.memberId)
                .point(this.point)
                .build();
    }
}
