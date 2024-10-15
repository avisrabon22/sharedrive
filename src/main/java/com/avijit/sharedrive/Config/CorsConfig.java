package com.avijit.sharedrive.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    //    Cors Configuration ***************************************************
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins("http://localhost:5173") // Allowed frontend origins (React, etc.)
                        .allowedMethods("*") // Allowed HTTP methods
                        .allowedHeaders("*") // Allowed headers
                        .allowCredentials(true); // Allow credentials like cookies or authorization headers
            }
        };
    }
}
