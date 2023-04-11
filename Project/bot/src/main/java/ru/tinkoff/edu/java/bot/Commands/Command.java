package ru.tinkoff.edu.java.bot.Commands;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public interface Command {
    String command();

    String description();

    SendMessage serve(Update update);

    default BotCommand toApiCommand() {
        return new BotCommand(command(), description());
    }
}
