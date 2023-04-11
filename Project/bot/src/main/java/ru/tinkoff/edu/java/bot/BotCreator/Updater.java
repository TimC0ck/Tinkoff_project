package ru.tinkoff.edu.java.bot.BotCreator;


import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import ru.tinkoff.edu.java.bot.Commands.Command;
import ru.tinkoff.edu.java.bot.Commands.Track;
import ru.tinkoff.edu.java.bot.Commands.Untrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Updater {
    private final List<? extends Command> commands;
    private final List<Long> trackRequest = new ArrayList<>();
    private final List<Long> untrackRequest = new ArrayList<>();

    public Updater(Command... commands) {
        this.commands = Arrays.stream(commands).toList();
    }

    public SendMessage processCommand(Update update) {
        if (update.message().text().startsWith("/")) {
            trackRequest.remove(update.message().chat().id());
            untrackRequest.remove(update.message().chat().id());
            String command = update.message().text().substring(1);
            Command processor = commands.stream().filter(el -> el.command().equals(command))
                    .findAny().orElse(null);
            if (processor == null) {
                return invalidCommandMessage(update);
            }
            else {
                if (processor instanceof Track) {
                    trackRequest.add(update.message().chat().id());
                }
                if (processor instanceof Untrack) {
                    untrackRequest.add(update.message().chat().id());
                }
                return processor.serve(update);
            }
        }
        if (trackRequest.contains(update.message().chat().id())) {
            return commands.stream().filter(el -> el.command().equals("track")).findFirst().get().serve(update);
        }
        if (untrackRequest.contains(update.message().chat().id())) {
            return commands.stream().filter(el -> el.command().equals("untrack")).findFirst().get().serve(update);
        }
        return invalidCommandMessage(update);
    }

    private SendMessage invalidCommandMessage(Update update) {
        return new SendMessage(update.message().chat().id(), "<b>Это пиздец!</b>\n " +
                "Чтобы ебануться в край, напишите /help").parseMode(ParseMode.HTML);
    }
}