package com.example.demo.model;

import java.time.LocalDateTime;

public class UrlMapping {
    private final String shortKey;
    private final String longUrl;
    private final String userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime expiresAt; // Nullable
    private long clickCount;

    public UrlMapping(String shortKey, String longUrl, String userId, Integer ttlInMinutes) {
        this.shortKey = shortKey;
        this.longUrl = longUrl;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
        this.expiresAt = (ttlInMinutes != null && ttlInMinutes > 0) ? this.createdAt.plusMinutes(ttlInMinutes) : null;
        this.clickCount = 0;
    }

    public boolean isExpired() {
        return expiresAt != null && LocalDateTime.now().isAfter(expiresAt);
    }

    public synchronized void incrementClicks() {
        this.clickCount++;
    }

    public String getShortKey() {
        return shortKey;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public long getClickCount() {
        return clickCount;
    }
}
