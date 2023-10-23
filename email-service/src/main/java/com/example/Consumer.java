package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final Logger log = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(id = "email", topics = "email")
    public void listen(Report report) {
        log.info("CONSUMING MESSAGE: " + report);
        log.info(String.format("Sending email with id: " + report.id() + " user id: "+ report.userId() + " username: "+ report.username() + "and operation: " + report.operation()));
    }
}
