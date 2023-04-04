package ru.tinkoff.edu.java.bot.BotCreator;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;

public class Bot {
    @Value("${apitoken}")
    private String token;
    TelegramBot bot = new TelegramBot(token);

}
