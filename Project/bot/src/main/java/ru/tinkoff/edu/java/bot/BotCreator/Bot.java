package ru.tinkoff.edu.java.bot.BotCreator;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;
import ru.tinkoff.edu.java.bot.Commands.*;

public class Bot {
    @Value("${apitoken}")
    private String token;
    TelegramBot bot = new TelegramBot(token);

    public Bot(String token, Start start, List list, Track track, Untrack untrack, Help help) {
    }
}
