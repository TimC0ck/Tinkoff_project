package ru.tinkoff.edu.java.bot.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLink {
    private Long id;
    private URI url;
    private String description;
    private List<Long> tgChatIds;
}