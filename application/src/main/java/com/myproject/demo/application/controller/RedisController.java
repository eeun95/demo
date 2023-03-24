package com.myproject.demo.application.controller;

import com.myproject.demo.domain.dto.code.ResultCodeEnum;
import com.myproject.demo.domain.dto.response.CommonResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/redisTest")
    public CommonResponseDto addRedisKey() {
        ValueOperations<String, String> op = redisTemplate.opsForValue();
        op.set("name", "netflix");
        op.set("price", "14500");
        op.set("personal", "4");
        return new CommonResponseDto(ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/redisTest/{key}")
    public CommonResponseDto getRedisKey(@PathVariable String key) {
        ValueOperations<String, String> op = redisTemplate.opsForValue();
        String value = op.get(key);
        return new CommonResponseDto(ResultCodeEnum.SUCCESS, value);
    }

    @GetMapping("/redisTest2")
    public CommonResponseDto addRedisKey2() {
        ZSetOperations<String, String> op = redisTemplate.opsForZSet();
        op.add("hot", "latte", 1);
        op.add("hot", "americano", 10);
        op.add("hot", "coldbrew", 2);
        op.add("hot", "espresso", 3);
        return new CommonResponseDto(ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/redisTest2/{key}")
    public CommonResponseDto getRedisKey2(@PathVariable String key) {
        ZSetOperations<String, String> op = redisTemplate.opsForZSet();
        log.info("randomMember {}", op.randomMember("hot"));
        return new CommonResponseDto(ResultCodeEnum.SUCCESS);
    }

}
