package ru.tinkoff.edu.java.bot.records;
import java.net.URI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tinkoff.edu.java.scrapper.DTO.response.LinkResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinksResponse {
    private List<LinkResponse> links;
    private Integer size;
}