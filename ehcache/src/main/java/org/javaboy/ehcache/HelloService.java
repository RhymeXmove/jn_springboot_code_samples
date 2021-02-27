package org.javaboy.ehcache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "user")
public class HelloService {
    @Cacheable
    public String hello(String name) {
        System.out.println(name);
        return "hello " + name;
    }
}
