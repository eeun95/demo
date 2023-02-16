package com.myproject.demo.Exception;

import lombok.Data;
import lombok.Getter;

@Data
public class ExceptionResponse {
    private ErrorCode code;
    private String errorMsg;

    public ExceptionResponse(ErrorCode code) {
        this.code = code;
        this.errorMsg = code.getMessage();
    }
}
