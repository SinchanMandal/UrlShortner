package com.example.demo.dto;

import java.time.LocalDateTime;

public class ShortenUrlResponse {
    private String shortKey;
    private String shortUrl;
    private String longUrl;
    private LocalDateTime expiresAt;

    public ShortenUrlResponse(String shortKey, String shortUrl, String longUrl, LocalDateTime expiresAt) {
        this.shortKey = shortKey;
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.expiresAt = expiresAt;
    }

    public String getShortKey() {
        return shortKey;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}