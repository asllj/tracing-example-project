package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReportingService {

    Logger logger = LoggerFactory.getLogger(ReportingService.class);

    @Autowired
    private ReportingRepository repository;
    @Autowired
    private EmailProducer producer;

    public void processReport(Report report){
        repository.save(report);
        logger.info("Sending info for kafka");
        producer.sendMail(report);
    }
}
