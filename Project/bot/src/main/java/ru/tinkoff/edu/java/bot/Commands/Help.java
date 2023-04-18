package ru.tinkoff.edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;

public class Help implements Command{

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Выводит все команды";
    }

    @Override
    public SendMessage serve(Update update) {
        return new SendMessage(update.message().chat().id(), "Список доступных комманд: " +
                "\n /start - Регистрирует пользователя" +
                "\n /help - Выводит все комманды" +
                "\n /track - Добавить отслеживание ссылки" +
                "\n /untrack - Убрать отслеживание ссылки" +
                "\n /list - показать список отслеживаемых ссылок");
    }
}
