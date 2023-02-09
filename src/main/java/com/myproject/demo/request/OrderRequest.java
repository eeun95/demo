package com.myproject.demo.request;

import com.myproject.demo.domain.Menu.Coffee;
import com.myproject.demo.domain.Receipt;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderRequest {
    private Long memberId;
    private Map<String, Integer> menu;
}
