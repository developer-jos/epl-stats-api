package com.josh.backend_solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.*;
import org.zalando.logbook.json.JsonHttpLogFormatter;

import static org.zalando.logbook.Conditions.*;
import static org.zalando.logbook.HeaderFilters.authorization;
import static org.zalando.logbook.QueryFilters.replaceQuery;
import static org.zalando.logbook.json.JsonPathBodyFilters.jsonPath; // ✅ Corrected single import

@Configuration
public class LogbookConfiguration {

    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .condition(exclude(
                        requestTo("/health"),
                        requestTo("/admin/**"),
                        requestTo("/swagger-ui/**"),
                        requestTo("/v3/api-docs/**"),
                        contentType("application/octet-stream")
                ))
                .queryFilter(replaceQuery("password", "<hidden>"))
                .bodyFilter(jsonPath("$.password").replace("<hidden>"))
                .headerFilter(authorization())
                .sink(new DefaultSink(
                        new JsonHttpLogFormatter(),
                        new StreamHttpLogWriter(System.out)
                ))
                .build();
    }
}
