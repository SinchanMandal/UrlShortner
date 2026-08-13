package com.example.demo.controller;

import com.example.demo.dto.ShortenUrlRequest;
import com.example.demo.dto.ShortenUrlResponse;
import com.example.demo.service.UrlShortnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {
    private final UrlShortnerService urlShortnerService;

    public UrlShortenerController(UrlShortnerService urlShortnerService) {
        this.urlShortnerService = urlShortnerService;
    }

    @PostMapping("api/v1/urls")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        ShortenUrlResponse response = urlShortnerService.createShortUrl(shortenUrlRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("api/v1/getAll")
    public Object getAll() {
        Object response = urlShortnerService.getAllUrl();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
