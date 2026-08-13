package com.example.demo.dto;

public class ShortenUrlRequest {
    public String longUrl;
    public String customAlias;
    public Integer ttlInMinutes;
    public String userId;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getCustomAlias() {
        return customAlias;
    }

    public void setCustomAlias(String customAlias) {
        this.customAlias = customAlias;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTtlInMinutes() {
        return ttlInMinutes;
    }

    public void setTtlInMinutes(Integer ttlInMinutes) {
        this.ttlInMinutes = ttlInMinutes;
    }
}
