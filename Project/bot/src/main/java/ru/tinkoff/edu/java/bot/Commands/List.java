package ru.tinkoff.edu.java.bot.Commands;

import com.github.dockerjava.api.exception.InternalServerErrorException;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.exceptions.ApiClientErrorException;
import ru.tinkoff.edu.java.bot.records.LinkApiResponse;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;

public class List implements Command{
    private final ScrapperClient scrapperClient = null;

    @Override
    public String command() {
        return "list";
    }

    @Override
    public String description() {
        return "Показывает список отслеживаемых ссылок";
    }

    @Override
    public SendMessage serve(Update update) {
        LinkApiResponse listLinksResponse;
        try {
            listLinksResponse = scrapperClient.getAllLinks(update.message().chat().id());
        } catch (ApiClientErrorException e) {
            return new SendMessage(update.message().chat().id(),"Список отслеживаемых ссылок пуст!");
        } catch (InternalServerErrorException e) {
            return new SendMessage(update.message().chat().id(),"Список отслеживаемых ссылок пуст!");
        }
        var builder = new StringBuilder();
        if (listLinksResponse.size() == 0) {
            builder.append("Список отслеживаемых ссылок пуст!");
        } else {
            builder.append("Вы отслеживаете следующие ссылки:\n");
            listLinksResponse.links().forEach(x -> builder.append(x.url()).append("\n"));
        }
        return new SendMessage(update.message().chat().id(), builder.toString());
    }

}

