package ru.tinkoff.edu.java.scrapper.ClientRef;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.DTO.response.GitHubResponse;

public class GitHubClient {
    @Value("$githubcl-baseurl")
    private String GHBaseUrl;
    WebClient ghClient;
    public GitHubClient() {
        this.ghClient = WebClient.create(GHBaseUrl);
    }
    public GitHubClient(String BaseURL){
        this.ghClient = WebClient.create(BaseURL);
    }
    public GitHubResponse getRepo(String owner, String repository){
        GitHubResponse response = ghClient.get()
                .uri("/repos/{owner}/{repository}", owner, repository)
                .retrieve()
                .bodyToMono(GitHubResponse.class).block();
        return response;
    }

}


