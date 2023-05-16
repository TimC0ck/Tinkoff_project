package ru.tinkoff.edu.java.bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.Commands.*;
import ru.tinkoff.edu.java.bot.BotCreator.*;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;


@Configuration
public class BotConfig {
    @Bean
    public Bot bot(
            ApplicationConfig config,
            ScrapperClient client
    ){
        return new Bot(
                config.token(),
                new Start(client),
                new List(client),
                new Track(client),
                new Untrack(client),
                new Help());
    }
}