package ru.tinkoff.edu.java.scrapper.Clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.DTO.response.StackOverflowResponse;

public class StackOverflowClient {
    @Value("$stackoverflowcl-baseurl")
    private String SOBaseUrl;
    final WebClient soClient;

    public StackOverflowClient() {
        this.soClient = WebClient.create(SOBaseUrl);
    }
    public StackOverflowClient(String BaseUrl) {
        this.soClient = WebClient.create(BaseUrl);
    }
    public StackOverflowResponse getQuestion(String id){
        StackOverflowResponse response = soClient.get()
                .uri("/questions/{id}", id)
                .retrieve()
                .bodyToMono(StackOverflowResponse.class).block();
        return response;
    }
}
