package ru.tinkoff.edu.java.bot.records;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkApiResponse {
    private Long id;
    private URI url;
}