package com.electems.Student.Configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * This class is used for ceating swagger documentation which is helpfull for developers and testers.
 * Swagger document contains all the info about API's inour spring boot application
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/students/**")
                .build();
    }
}
