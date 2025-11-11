package com.chandan.interview.practice.test.practice;

import java.util.concurrent.ConcurrentHashMap;

class Bucket {
    private final long capacity;
    private final double refillRatePerMillis; // tokens per ms
    private double tokens;
    private long lastRefillTimestamp;

    public Bucket(long capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerMillis = refillRatePerSecond / 1000.0;
        this.tokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    // synchronized ensures thread safety per bucket
    public synchronized boolean tryConsume() {
        refill();
        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastRefillTimestamp;
        if (elapsed > 0) {
            double newTokens = elapsed * refillRatePerMillis;
            tokens = Math.min(capacity, tokens + newTokens);
            lastRefillTimestamp = now;
        }
    }
}

public class TokenBucketRateLimiter {

    private final ConcurrentHashMap<String, Bucket> buckets = new ConcurrentHashMap<>();
    private final long capacity;
    private final double refillRatePerSecond;

    public TokenBucketRateLimiter(long capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
    }

    public boolean allowRequest(String userId) {
        Bucket bucket = buckets.computeIfAbsent(userId,
                k -> new Bucket(capacity, refillRatePerSecond));
        return bucket.tryConsume();
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(3, 2); // 5 tokens, 2 tokens/sec
        String user = "user1";

        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + limiter.allowRequest(user+i));
            Thread.sleep(200);
        }
    }
}
