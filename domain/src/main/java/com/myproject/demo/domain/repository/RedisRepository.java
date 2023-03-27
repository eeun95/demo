package com.myproject.demo.domain.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RedisRepository {

    @Autowired
    private final RedisTemplate<String, String> redisTemplate;

    public void saveRedis(String key, int count) {
        ZSetOperations<String, String> op = redisTemplate.opsForZSet();
        op.add("hot", key, count);
    }

    public int getScore(String key, String value) {
        ZSetOperations<String, String> op = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> typedTuples = op.rangeWithScores(key, 0, -1);
        for (ZSetOperations.TypedTuple<String> typedTuple : typedTuples) {
            if(typedTuple.getValue().equals(value)) {
                return (int) (typedTuple.getScore()*1);
            }
        }
        return 0;
    }

    public List getValueList(String key, int limit) {
        ZSetOperations<String, String> op = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<String>> tupleSet = op.reverseRangeWithScores("hot", 0, limit);
        List<String> list = tupleSet.stream().map(ZSetOperations.TypedTuple::getValue).collect(Collectors.toList());
        return list;
    }
}
