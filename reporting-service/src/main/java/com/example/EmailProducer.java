package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {

    @Autowired
    private KafkaTemplate<Object,Object> template;

    public void sendMail(Report report){
        template.send("email",report);
    }
}
