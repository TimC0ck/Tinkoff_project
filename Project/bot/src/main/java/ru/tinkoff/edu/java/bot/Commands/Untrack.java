package ru.tinkoff.edu.java.bot.Commands;

import com.github.dockerjava.api.exception.InternalServerErrorException;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.exceptions.ApiClientErrorException;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;

public class Untrack implements Command{
    private ScrapperClient scrapperClient;
    @Override
    public String command() {
        return "untrack";
    }

    @Override
    public String description() {
        return "Прекращает отслеживание ссылки";
    }

    @Override
    public SendMessage serve(Update update){
        if (update.message().text().substring(1).equals(command())) {
            return new SendMessage(update.message().chat().id(), "Введите ссылку для прекращения отслеживания");
        }
        try {
            scrapperClient.deleteLink(update.message().chat().id(), update.message().text());
        } catch (ApiClientErrorException e) {
            return new SendMessage(update.message().chat().id(),"Такой ссылки не было добавлено!");
        } catch (InternalServerErrorException e) {
            return new SendMessage(update.message().chat().id(),"Error!");
        }
        return new SendMessage(update.message().chat().id(), "Ссылка успешно удалена из списка для отслеживания");
    }
}
