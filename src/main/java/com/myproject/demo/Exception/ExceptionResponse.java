package com.myproject.demo.Exception;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private Long id;
    private String errorMsg;

    public ExceptionResponse(Long id, String errorMsg) {
        this.id = id;
        this.errorMsg = errorMsg;
    }
}
