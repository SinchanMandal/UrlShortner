package com.example.demo.strategy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class Base62CounterStrategy implements KeyGenerationStrategy {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Starting counter seed
    private final AtomicLong counter = new AtomicLong(1000000000L);

    @Override
    public String generateKey() {
        long id = counter.getAndIncrement();
        long time = System.currentTimeMillis();

        String timeStamp = encodeBase62(time);
        String genKey = encodeBase62(id);

        // Convert timeStamp to a char array so we can modify individual characters
        char[] timeChars = timeStamp.toCharArray();
        char[] keyChars = genKey.toCharArray();

        // Pick 2 or 3 random replacements to keep it randomized
        int replacements = Math.min(2, keyChars.length);

        for (int i = 0; i < replacements; i++) {
            // Pick a random char from genKey
            int randomKeyIdx = ThreadLocalRandom.current().nextInt(keyChars.length);
            char charToInject = keyChars[randomKeyIdx];

            // Pick a random index in timeChars to replace
            int randomTimeIdx = ThreadLocalRandom.current().nextInt(timeChars.length);

            // Replace character at random position
            timeChars[randomTimeIdx] = charToInject;
        }

        String randomizedKey = new String(timeChars);

        System.out.println("Original Timestamp String: " + timeStamp);
        System.out.println("Randomized Interleaved Key: " + randomizedKey);

        return randomizedKey;
    }

    private String encodeBase62(long id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            int tempId = (int) (id % 62);
            sb.append(BASE62.charAt(tempId));
            id = id/62;
        }
        return sb.reverse().toString();
    }
}
