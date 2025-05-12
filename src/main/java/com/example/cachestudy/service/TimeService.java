package com.example.cachestudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class TimeService {
    private final RestClient restClient = RestClient.create("https://timeapi.io");

    private TimeApiResponse getCurrentTime() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/Time/current/zone")
                        .queryParam("timeZone", "Asia/Seoul")
                        .build())
                .retrieve()
                .body(TimeApiResponse.class);
    }

    @Cacheable("current-kor-time")
    public TimeApiResponse timeWithCache() {
        return getCurrentTime();
    }

    public TimeApiResponse timeWithoutCache() {
        return getCurrentTime();
    }
}
