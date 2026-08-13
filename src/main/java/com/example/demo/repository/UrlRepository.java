package com.example.demo.repository;


import com.example.demo.model.UrlMapping;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UrlRepository {
    void save(UrlMapping urlMapping);

    Optional<UrlMapping> findByShortKey(String shortKey);

    boolean existsShortKey(String shortKey);

    void delete(String shortKey);
    Object getAllKeys();
}
