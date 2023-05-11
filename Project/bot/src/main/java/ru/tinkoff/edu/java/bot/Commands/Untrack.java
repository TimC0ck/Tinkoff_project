package ru.tinkoff.edu.java.bot.Commands;


import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import ru.tinkoff.edu.java.bot.exceptions.ApiClientErrorException;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;


@AllArgsConstructor
public class Untrack implements Command {
    private final ScrapperClient client;

    @Override
    public String command() {
        return "untrack";
    }

    @Override
    public String description() {
        return "Прекратить отслеживание ссылки";
    }

    @Override
    public SendMessage process(Update update) {
        if (update.message().text().substring(1).equals(command())) {
            return new SendMessage(update.message().chat().id(), "Введите ссылку для прекращения отслеживания");
        }
        boolean result = client.deleteTrackedLink(update.message().chat().id(), update.message().text());
        if (!result) {
            return new SendMessage(update.message().chat().id(), "Ошибка\nПопробуйте еще раз");
        }
        return new SendMessage(update.message().chat().id(), "Ссылка успешно удалена из списка");
    }
}
