package ru.tinkoff.edu.java.bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;

@Configuration
public class ClientConfig {
    @Bean
    public ScrapperClient scrapperClient() {
        return new ScrapperClient();
    }
}