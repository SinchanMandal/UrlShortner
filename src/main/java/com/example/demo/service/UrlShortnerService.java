package com.example.demo.service;


import com.example.demo.dto.ShortenUrlRequest;
import com.example.demo.dto.ShortenUrlResponse;
import com.example.demo.model.UrlMapping;
import com.example.demo.repository.UrlRepository;
import com.example.demo.strategy.KeyGenerationStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlShortnerService {
    private final UrlRepository repository;
    private final KeyGenerationStrategy keyStrategy;
    private final String baseUrl;

    public UrlShortnerService(UrlRepository repository, KeyGenerationStrategy keyStrategy, @Value("${app.base-url:http://localhost:8080/}") String baseUrl) {
        this.repository = repository;
        this.keyStrategy = keyStrategy;
        this.baseUrl = baseUrl;
    }

    public ShortenUrlResponse createShortUrl(ShortenUrlRequest req) {
        String key;
        key = keyStrategy.generateKey();
        UrlMapping urlMapping = new UrlMapping(key, req.longUrl, req.getUserId(), req.getTtlInMinutes());
        repository.save(urlMapping);
        return new ShortenUrlResponse(key, baseUrl + key, urlMapping.getLongUrl(), urlMapping.getExpiresAt());
    }
    public Object getAllUrl() {
     return repository.getAllKeys();
    }

}
