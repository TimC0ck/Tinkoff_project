package ru.tinkoff.edu.java.bot.service;


import ru.tinkoff.edu.java.bot.DTO.request.UpdateLink;
import ru.tinkoff.edu.java.bot.BotCreator.Bot;

public class HttpLinkUpdateReceiver extends LinkUpdateReceiver {
    public HttpLinkUpdateReceiver(Bot bot) {
        super(bot);
    }

    @Override
    public void receiveUpdate(UpdateLink request) {
        this.sendUpdates(request);
    }
}