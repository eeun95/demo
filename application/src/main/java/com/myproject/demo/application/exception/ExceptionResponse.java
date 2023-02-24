package com.myproject.demo.application.exception;

import com.myproject.demo.domain.dto.code.ErrorCodeEnum;
import lombok.Data;

@Data
public class ExceptionResponse {
    private ErrorCodeEnum code;
    private String errorMsg;

    public ExceptionResponse(ErrorCodeEnum code) {
        this.code = code;
        this.errorMsg = code.getMessage();
    }
}
