package org.javaboy.ehcache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EhcacheApplicationTests {
    @Autowired
    HelloService helloService;

    @Test
    public void contextLoads() {
        String helloservicetest = helloService.hello("单");
        System.out.println(helloservicetest);
    }

}
