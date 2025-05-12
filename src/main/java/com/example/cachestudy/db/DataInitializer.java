package com.example.cachestudy.db;

import com.example.cachestudy.db.post.Post;
import com.example.cachestudy.db.post.PostRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {

    private final PostRepository postRepository;


    @PostConstruct
    @Transactional
    public void init() {
        log.info("data init start");

        for (int i = 0; i < 10; i++) {
            Post post = Post.create(UUID.randomUUID().toString());
            postRepository.save(post);

        }
    }


}
