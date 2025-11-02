package com.email.writer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(@Value("${gemini.api.url}") String geminiApi) {
        return WebClient.builder()
                .baseUrl(geminiApi)
                .build();
    }

}