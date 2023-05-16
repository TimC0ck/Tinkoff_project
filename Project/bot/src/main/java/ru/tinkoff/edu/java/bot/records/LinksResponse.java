package ru.tinkoff.edu.java.bot.records;
import java.net.URI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static com.pengrad.telegrambot.model.MessageEntity.Type.url;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinksResponse {
    private List<LinksResponse> links;
    private Integer size;

    public Object getUrl() {
        return url;
    }
}