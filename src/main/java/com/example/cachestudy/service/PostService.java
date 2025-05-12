package com.example.cachestudy.service;

import com.example.cachestudy.db.post.Post;
import com.example.cachestudy.db.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    @Cacheable(value = "post", key = "#id")
    public PostDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();

        return new PostDto(post.getId(), post.getContent(), post.getCreatedAt(), post.getModifiedAt());
    }

    @CacheEvict(value = "post", key = "#id")
    public void deleteById(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
    }
}
