package ru.tinkoff.edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;

public class Track implements Command{
    private ScrapperClient scrapperClient;

    @Override
    public String command() {
        return "track";
    }

    @Override
    public String description() {
        return "Начинает отслеживание ссылки";
    }

    @Override
    public SendMessage serve(Update update){
        if (update.message().text().substring(1).equals(command())) {
            return new SendMessage(update.message().chat().id(), "Введите ссылку для отслеживания");
        }

        scrapperClient.addLink(update.message().chat().id(), update.message().text());
        return new SendMessage(update.message().chat().id(), "Ссылка успешно добавлена в список для отслеживания");
    }
}
