package ru.tinkoff.edu.java.scrapper.clientConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.scrapper.Clients.GitHubClient;
import ru.tinkoff.edu.java.scrapper.Clients.StackOverflowClient;

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
