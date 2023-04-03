package ru.tinkoff.edu.java.scrapper.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;


public class LinkUpdateScheduler {

    @Scheduled(fixedDelayString = "${app.scheduler.interval}")
    public void update(){
        final Logger logger = LoggerFactory
                .getLogger(LinkUpdateScheduler.class);
        logger.info("Updated!");
    }
}
