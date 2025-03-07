package com.josh.backend_solution.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("🏆 EPL Stats API")
                        .description("Comprehensive Premier League Player Stats API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Joshua Ntayibu")
                                .email("joshua.d.programmer@gmail.com")
                        )
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")
                        )
                );
    }
}
