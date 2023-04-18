package ru.tinkoff.edu.java.bot.Commands;

import com.github.dockerjava.api.exception.InternalServerErrorException;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import ru.tinkoff.edu.java.bot.exceptions.ApiClientErrorException;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;

public class Start implements Command{
    private ScrapperClient scrapperClient;


    @Override
    public String command() {
        return "start";
    }

    @Override
    public String description() {
        return "Регистрирует пользователя";
    }

    @Override
    public SendMessage serve(Update update){
        try {
            scrapperClient.registerChat(update.message().chat().id());
        } catch (InternalServerErrorException e) {
            System.out.println();
        } catch (ApiClientErrorException e) {
            return new SendMessage(update.message().chat().id(),"Пользователь уже зарегистрирован");
        }
        return new SendMessage(update.message().chat().id(), getText(update.message().chat().firstName()))
                .parseMode(ParseMode.HTML);
    }

    private String getText(String Name) {
        return "<b>Чтобы получить список команд, используйте команду</b>  /help";
    }
}
