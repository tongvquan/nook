package com.tongquan.nook.shared.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        var license = new License().name("Apache 2.0").url("https://springdoc.org");

        var info = new Info()
                .title("Spring Boot 4 REST API")
                .version("1.0.0")
                .description("Automated API documentation using Springdoc OpenAPI 3")
                .license(license);

        return new OpenAPI().info(info);
    }
}
