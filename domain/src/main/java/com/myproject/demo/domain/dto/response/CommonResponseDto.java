package com.myproject.demo.domain.dto.response;

import com.myproject.demo.domain.dto.code.ResultCodeEnum;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class CommonResponseDto<T> {
    private ResultCodeEnum code;
    private String resultMessage;
    private T data;

    public CommonResponseDto(ResultCodeEnum code) {
        this.code = code;
        this.resultMessage = code.getMessage();
    }

    public CommonResponseDto(ResultCodeEnum code, T data) {
        this.code = code;
        this.resultMessage = code.getMessage();
        this.data = data;
    }
}
