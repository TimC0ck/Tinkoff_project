package ru.tinkoff.edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class Start implements Command{
    @Override
    public String command() {
        return "start";
    }

    @Override
    public String description() {
        return "Регистрирует пользователя";
    }

    @Override
    public SendMessage serve(Update update) {
        return null;
    }
}
