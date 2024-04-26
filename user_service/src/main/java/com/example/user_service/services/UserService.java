package com.example.user_service.services;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    RestTemplate restTemplate = new RestTemplate();
//    @Retry(name = "retryApi")
    @RateLimiter(name = "rateLimiterApi")
    public List<Map<String, Object>> getAllProduct() {
        ResponseEntity< List<Map<String, Object>>> responseEntity = restTemplate.exchange(
                "http://localhost:8081/product-service/read",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        );
        return responseEntity.getBody();
    }
}
