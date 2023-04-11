package ru.tinkoff.edu.java.scrapper.DTO.response;

import java.net.URI;

public record ListLinksResponse(LinkResponse[] links, long size) {

}
