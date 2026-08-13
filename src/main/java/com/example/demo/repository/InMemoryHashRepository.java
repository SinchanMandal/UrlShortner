package com.example.demo.repository;


import com.example.demo.model.UrlMapping;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryHashRepository implements UrlRepository {
    public final ConcurrentHashMap<String, UrlMapping> db = new ConcurrentHashMap<>();

    @Override
    public void save(UrlMapping urlMapping) {
        if (urlMapping.getShortKey() != null) {
            db.put(urlMapping.getShortKey(), urlMapping);
        }
    }

    @Override
    public Optional<UrlMapping> findByShortKey(String shortKey) {
        return Optional.ofNullable(db.get(shortKey));
    }

    @Override
    public boolean existsShortKey(String shortKey) {
        return db.containsKey(shortKey);
    }

    @Override
    public void delete(String shortKey) {
        db.remove(shortKey);
    }
    @Override
   public Object getAllKeys()
    {
        List<Object>allEntities=new ArrayList<>();
       db.forEach((key,value)->{
           allEntities.add(value);
       });
       return  allEntities;
    }
}
