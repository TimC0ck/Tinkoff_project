package ru.tinkoff.edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class List implements Command{
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
        return new SendMessage(update.message().chat(), "a");
    }
}
