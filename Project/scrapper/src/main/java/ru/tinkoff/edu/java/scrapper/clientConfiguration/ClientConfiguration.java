package ru.tinkoff.edu.java.scrapper.clientConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.ClientRef.GitHubClient;
import ru.tinkoff.edu.java.scrapper.ClientRef.StackOverflowClient;

@Configuration
public class ClientConfiguration {
    @Value("${githubcl-baseurl}")
    String ghBaseUrl;
    @Value("${stackoveflowcl-baseurl}")
    String soBaseUrl;
    @Bean
    GitHubClient gitHubClient(){
        return new GitHubClient(ghBaseUrl);
    }
    @Bean
    StackOverflowClient stackOverflowClient(){
        return new StackOverflowClient(ghBaseUrl);
    }
}
