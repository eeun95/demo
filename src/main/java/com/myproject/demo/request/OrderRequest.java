package com.myproject.demo.request;

import lombok.Data;

import java.util.Map;

@Data
public class OrderRequest {
    private Long memberId;
    private Map<String, Integer> menu;
}
