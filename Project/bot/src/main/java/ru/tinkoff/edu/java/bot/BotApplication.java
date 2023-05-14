package ru.tinkoff.edu.java.bot;

import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.context.properties.EnableConfigurationProperties;

        import ru.tinkoff.edu.java.bot.Commands.*;
        import org.springframework.context.annotation.Bean;
        import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
        import ru.tinkoff.edu.java.bot.BotCreator.Bot;
        import ru.tinkoff.edu.java.bot.scrapper.ScrapperClient;


@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication
{

    public static void main( String[] args )
    {
        var ctx = SpringApplication.run(BotApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        ScrapperClient client = ctx.getBean(ScrapperClient.class);
        Bot bot = new Bot(
                config.token(),
                new Start(client),
                new List(client),
                new Track(client),
                new Untrack(client),
                new Help());
    }

    @Bean
    public ScrapperClient scrapperClient() {
        return new ScrapperClient();
    }
}