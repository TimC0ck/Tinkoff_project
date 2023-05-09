package ru.tinkoff.edu.java.scrapper.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LinkUpdateScheduler {
    final Logger logger = LoggerFactory
            .getLogger(LinkUpdateScheduler.class);
    @Scheduled(fixedDelayString = "${app.scheduler.interval}")
    public void update(){
        logger.info("Updated!");
    }
}
