package ru.tinkoff.edu.java.bot.scrapper;

import ru.tinkoff.edu.java.bot.records.LinkApiResponse;
import ru.tinkoff.edu.java.bot.records.LinksResponse;


public interface ScrapperClient {

    void registerChat(long chatId);

    void deleteChat(long chatId);

    LinkApiResponse getAllLinks(long tgChatId);

    LinksResponse addLink(long tgChatId, String link);

    LinksResponse deleteLink(long tgChatId, String link);
}