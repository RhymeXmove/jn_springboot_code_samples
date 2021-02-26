package org.javaboy.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    HelloService helloService;

    @Test
    public void contextLoads() {
        System.out.println("hello1:");
        helloService.hello();
        System.out.println("hello2:");
        helloService.hello2();
    }

}
