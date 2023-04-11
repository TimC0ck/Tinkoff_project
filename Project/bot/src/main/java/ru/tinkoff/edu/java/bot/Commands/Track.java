package ru.tinkoff.edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class Track implements Command{
    @Override
    public String command() {
        return "track";
    }

    @Override
    public String description() {
        return "Начинает отслеживание ссылки";
    }

    @Override
    public SendMessage serve(Update update) {
        return null;
    }
}
