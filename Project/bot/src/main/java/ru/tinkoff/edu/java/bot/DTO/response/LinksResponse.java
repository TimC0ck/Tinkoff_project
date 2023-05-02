package ru.tinkoff.edu.java.bot.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinksResponse {
    private List<LinkApiResponse> links;
    private Integer size;
}