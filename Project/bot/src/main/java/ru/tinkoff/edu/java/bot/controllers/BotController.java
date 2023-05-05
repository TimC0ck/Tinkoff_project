package ru.tinkoff.edu.java.bot.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.DTO.request.UpdateLink;

@RestController()
public class BotController {

    @PostMapping("/updates")
    public void update(@RequestBody UpdateLink request) {
        System.out.println(request.getUrl());
        System.out.println(request.getDescription());
        System.out.println(request.getTgChatIds());
    }
}