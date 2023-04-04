package ru.tinkoff.edu.java.bot.scrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.bot.records.DeleteLinkRequest;
import ru.tinkoff.edu.java.bot.records.LinkApiResponse;
import ru.tinkoff.edu.java.bot.records.LinksResponse;
import ru.tinkoff.edu.java.bot.records.AddLinkRequest;
import ru.tinkoff.edu.java.scrapper.DTO.response.ApiErrorResponse;


import static org.springframework.http.HttpMethod.DELETE;
import ru.tinkoff.edu.java.bot.exceptions.internalServerErrorException;
import ru.tinkoff.edu.java.bot.exceptions.ApiClientErrorException;
public class HttpScrapperClient implements ScrapperClient {

    public static final String TG_CHAT_ID_HEADER = "Tg-Chat-Id";
    private static final Logger LOGGER = LogManager.getLogger(HttpScrapperClient.class);
    private static final String BASE_URL = "http://localhost:8080";
    public static final String TG_CHAT_URL = "/tg-chat/{id}";
    public static final String LINKS_URL = "/links";

    private final String baseUrl;
    private final WebClient webClient;

    public HttpScrapperClient(WebClient webClient) {
        this.webClient = webClient;
        baseUrl = BASE_URL;
    }

    public HttpScrapperClient(String baseUrl, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }

    @Override
    public void registerChat(long chatId) {
        webClient.post().uri(baseUrl + TG_CHAT_URL, chatId).retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        resp -> onClientErrorInternal(resp, "registering new chat")
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        resp -> onServerErrorInternal(resp, "registering new chat")
                )
                .bodyToMono(Void.class).block();
    }

    @Override
    public void deleteChat(long chatId) {
        webClient.delete().uri(baseUrl + TG_CHAT_URL, chatId).retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        resp -> onClientErrorInternal(resp, "deleting chat")
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        resp -> onServerErrorInternal(resp, "deleting chat")
                )
                .bodyToMono(Void.class).block();
    }

    @Override
    public LinkApiResponse getAllLinks(long tgChatId) {
        return webClient
                .get()
                .uri(baseUrl + LINKS_URL).header(TG_CHAT_ID_HEADER, String.valueOf(tgChatId))
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        resp -> onClientErrorInternal(resp, "getting tracking links")
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        resp -> onServerErrorInternal(resp, "getting tracking links")
                )
                .bodyToMono(LinkApiResponse.class).block();
    }

    @Override
    public LinksResponse addLink(long tgChatId, String link) {
        return webClient
                .post()
                .uri(baseUrl + LINKS_URL).header(TG_CHAT_ID_HEADER, String.valueOf(tgChatId))
                .bodyValue(new AddLinkRequest(link))
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        resp -> onClientErrorInternal(resp, "adding link to track")
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        resp -> onServerErrorInternal(resp, "adding link to track")
                )
                .bodyToMono(LinksResponse.class).block();
    }

    @Override
    public LinksResponse deleteLink(long tgChatId, String link) {
        return webClient
                .method(DELETE)
                .uri(baseUrl + LINKS_URL).header(TG_CHAT_ID_HEADER, String.valueOf(tgChatId))
                .body(Mono.just(new DeleteLinkRequest(link)), DeleteLinkRequest.class)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        resp -> onClientErrorInternal(resp, "removing link from tracking")
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        resp -> onServerErrorInternal(resp, "removing link from tracking")
                )
                .bodyToMono(LinksResponse.class).block();
    }

    private Mono<? extends RuntimeException> onClientErrorInternal(ClientResponse resp, String when) {
        LOGGER.error("Incorrect Scrapper API request while " + when);
        return resp.bodyToMono(ApiErrorResponse.class).map(ApiClientErrorException::new);
    }

    private Mono<? extends RuntimeException> onServerErrorInternal(ClientResponse resp, String when) {
        LOGGER.error("Scrapper API server error while " + when);
        return resp.bodyToMono(ApiErrorResponse.class).map(internalServerErrorException::new);
    }
}