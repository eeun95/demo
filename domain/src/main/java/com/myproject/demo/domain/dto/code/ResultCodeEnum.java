package com.myproject.demo.domain.dto.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "정상 처리되었습니다.");

    private final int status;
    private final String message;
}