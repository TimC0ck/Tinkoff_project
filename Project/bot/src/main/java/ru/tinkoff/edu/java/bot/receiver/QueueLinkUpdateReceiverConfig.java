package ru.tinkoff.edu.java.bot.receiver;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.BotCreator.*;
import ru.tinkoff.edu.java.bot.service.LinkUpdateReceiver;
import ru.tinkoff.edu.java.bot.service.QueueLinkUpdateReceiver;


@Configuration
@ConditionalOnProperty(prefix = "app", name = "use-queue", havingValue = "true")
public class QueueLinkUpdateReceiverConfig {
    @Bean
    public LinkUpdateReceiver linkUpdateReceiver(
            Bot bot
    ) {
        return new QueueLinkUpdateReceiver(bot);
    }
}