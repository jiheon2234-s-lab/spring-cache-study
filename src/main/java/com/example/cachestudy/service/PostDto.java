package com.example.cachestudy.service;

import java.time.Instant;

public record PostDto(
        Long id,
        String content,
        Instant createdAt,
        Instant modifiedAt
) {
}
