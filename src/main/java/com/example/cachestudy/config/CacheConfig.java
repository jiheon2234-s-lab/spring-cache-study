package com.example.cachestudy.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * 디폴트값
     * 이름처럼 conCurrentHashMap 사용
     */
//    @Bean
//    public CacheManager registConcurrentMapCacheManager() {
////        var c = new ConcurrentMapCacheManager("abc");
//        var c = new ConcurrentMapCacheManager();
//        return c;
//    }

}
