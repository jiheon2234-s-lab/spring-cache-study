package com.example.cachestudy.controller;

import com.example.cachestudy.service.PostDto;
import com.example.cachestudy.service.PostService;
import com.example.cachestudy.service.TimeApiResponse;
import com.example.cachestudy.service.TimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CacheController {

    private final TimeService timeService;
    private final PostService postService;
    private final CacheManager cacheManager;

    @GetMapping("/cash-manager")
    public Map<String, Object> getCacheManage() {
        System.out.println("cacheManager = " + cacheManager.getCache("post"));
        Map<String, Object> myMap = Map.of(
                "class", cacheManager.getClass(),
                "object", cacheManager.toString(),
                "getCacheNames", cacheManager.getCacheNames()
        );
        System.out.println("myMap = " + myMap);
        return myMap;
    }


    @GetMapping("/current-time")
    public TimeApiResponse getCurrentTime(@RequestParam(value = "cache", required = false) boolean c) {
        TimeApiResponse res;
        if (c) {
            res = timeService.timeWithCache();
        } else {
            res = timeService.timeWithoutCache();
        }
        return res;
    }


    @GetMapping("/post/{postId}")
    public PostDto cacheObject(@PathVariable Long postId) {
        return postService.findById(postId);
    }

    @DeleteMapping("/post/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
    }


}
