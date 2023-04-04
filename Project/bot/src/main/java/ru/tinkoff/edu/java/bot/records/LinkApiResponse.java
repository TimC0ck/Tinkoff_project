package ru.tinkoff.edu.java.bot.records;

import ru.tinkoff.edu.java.scrapper.DTO.response.LinkResponse;
import java.util.List;
public record LinkApiResponse(List<LinkResponse> links, int size) {
}