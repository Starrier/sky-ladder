package org.starrier.sky.ladder.distribution.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.ResponseEntity;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author starrier
 * @date 2020/11/28
 */
@Slf4j
@RestController
public class RedisController {

    private RedisTemplate redisTemplate;

    @GetMapping
    public ResponseEntity<Object> redisLuaTest(){
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/Test.lua")));
        redisScript.setResultType(Boolean.class);
        List<String> keys = Arrays.asList("testLua", "hello lua");
        Object execute = redisTemplate.execute(redisScript, keys, "100");
        assert execute != null;
        return ResponseEntity.ok(execute);
    }
}
