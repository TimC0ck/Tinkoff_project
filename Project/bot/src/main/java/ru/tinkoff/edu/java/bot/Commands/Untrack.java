package ru.tinkoff.edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class Untrack implements Command{
    @Override
    public String command() {
        return "untrack";
    }

    @Override
    public String description() {
        return "Прекращает отслеживание ссылки";
    }

    @Override
    public SendMessage serve(Update update) {
        return null;
    }
}
