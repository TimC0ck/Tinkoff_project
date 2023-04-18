package ru.tinkoff.edu.java.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import ru.tinkoff.edu.java.bot.Commands.*;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
import ru.tinkoff.edu.java.bot.BotCreator.Bot;
import ru.tinkoff.edu.java.bot.scrapper.HttpScrapperClient;
import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;

@ComponentScan
@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(BotApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
        ScrapperClient client = ctx.getBean(ScrapperClient.class);
        Bot TgBot = new Bot(
                config.bot().token(),
                new Start(client),
                new List(client),
                new Track(client),
                new Untrack(client),
                new Help());
    }
}
