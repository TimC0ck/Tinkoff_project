package ru.tinkoff.edu.java.bot.service;

import lombok.AllArgsConstructor;
import ru.tinkoff.edu.java.bot.DTO.request.UpdateLink;
import ru.tinkoff.edu.java.bot.BotCreator.Bot;

@AllArgsConstructor
public abstract class LinkUpdateReceiver {
    private Bot bot;

    public abstract void receiveUpdate(UpdateLink request);

    protected void sendUpdates(UpdateLink request) {
        bot.sendMessages(request.getDescription(), request.getTgChatIds());
    }
}