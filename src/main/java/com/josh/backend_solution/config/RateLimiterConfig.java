package com.josh.backend_solution.config;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;
import io.github.bucket4j.local.SynchronizationStrategy;
import io.github.bucket4j.local.LocalBucketBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimiterConfig {

    @Bean
    public Bucket bucket() {
        Bandwidth limit = Bandwidth.classic(50, Refill.greedy(50, Duration.ofMinutes(1)));
        return new LocalBucketBuilder()
                .addLimit(limit)
                .withSynchronizationStrategy(SynchronizationStrategy.LOCK_FREE) // ✅ Latest Bucket4j API
                .build();
    }
}
