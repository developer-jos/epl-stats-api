package com.josh.backend_solution.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class AppConfig {
    private String audience;
    private String grant_type;
    private String get_token_url;
    private String user_request_url;
    private String user_passwordless_url;



}
