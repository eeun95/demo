package com.myproject.demo.domain.dto.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    MEMBER_NOT_FOUND(404, "존재하지 않는 유저입니다."),
    NOT_ENOUGH_POINT(404, "포인트가 부족합니다.");

    private final int status;
    private final String message;

}

