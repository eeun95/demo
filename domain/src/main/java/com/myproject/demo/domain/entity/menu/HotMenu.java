package com.myproject.demo.domain.entity.menu;


import org.springframework.data.redis.core.RedisHash;

@RedisHash("HotMenu")
public class HotMenu {
    private String coffeeName;
}
