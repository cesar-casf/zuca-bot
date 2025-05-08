package com.zuca.zuca_bot.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.reactive.function.client.WebClient;

@Setter
@Configuration
public class WebClientConfig {

    @Value("${secret.football-api-token}")
    private String footballApiToken;

    @Bean
    @Qualifier("football-api")
    public WebClient webClient() {
        final int size = (int) DataSize.ofMegabytes(16).toBytes();

        return WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(size))
                .baseUrl("https://api.football-data.org/v4")
                .defaultHeader("X-Auth-Token", footballApiToken)
                .build();
    }
}
