package ru.tinkoff.edu.java.bot.scrapper;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.bot.records.AddLinkRequest;
import ru.tinkoff.edu.java.bot.records.DeleteLinkRequest;
import ru.tinkoff.edu.java.bot.records.LinkApiResponse;
import ru.tinkoff.edu.java.bot.records.LinksResponse;


import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class ScrapperClient {
    private final String BASE_URL = "http://localhost:8081/";

    private final WebClient WEB_CLIENT;

    public ScrapperClient() {
        WEB_CLIENT = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public ScrapperClient(String url) {
        WEB_CLIENT = WebClient.builder()
                .baseUrl(url)
                .build();
    }

    public void registerChat(Long id) {
        WEB_CLIENT.post()
                .uri("/tg-chat/" + id.toString())
                .retrieve()
                .bodyToMono(Void.class)
                .timeout(Duration.ofSeconds(10))
                .block();
    }

    public LinksResponse getListLinks(Long id) {
        return WEB_CLIENT.get()
                .uri("links")
                .header("Tg-Chat-Id", id.toString())
                .retrieve()
                .bodyToMono(LinksResponse.class)
                .timeout(Duration.ofSeconds(10))
                .onErrorReturn(new LinksResponse())
                .block();
    }

    public boolean addTrackedLink(Long id, String link) {
        AddLinkRequest request;
        try {
            request = new AddLinkRequest(new URI(link));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        LinkApiResponse response = WEB_CLIENT.post()
                .uri("links")
                .header("Tg-Chat-Id", id.toString())
                .body(Mono.just(request), AddLinkRequest.class)
                .retrieve()
                .bodyToMono(LinkApiResponse.class)
                .timeout(Duration.ofSeconds(10))
                .onErrorReturn(new LinkApiResponse())
                .block();
        return response != null && response.getUrl() != null && response.getUrl().toString().equals(link);
    }

    public boolean deleteTrackedLink(Long id, String link) {
        DeleteLinkRequest request;
        try {
            request = new DeleteLinkRequest(new URI(link));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        LinkApiResponse response = WEB_CLIENT.method(HttpMethod.DELETE)
                .uri("links")
                .header("Tg-Chat-Id", id.toString())
                .body(Mono.just(request), DeleteLinkRequest.class)
                .retrieve()
                .bodyToMono(LinkApiResponse.class)
                .timeout(Duration.ofSeconds(10))
                .onErrorReturn(new LinkApiResponse())
                .block();
        return response != null && response.getUrl() != null && response.getUrl().toString().equals(link);
    }
}