package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ReportingWebClient {

    @Autowired
    private WebClient webClient;

    public void createUserReporting(Long userId, String username, Operation operation){
        webClient.post()
                .uri("/reporting")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Report(UUID.randomUUID(),userId,operation,username), Report.class)
                .retrieve()
                .bodyToMono(Void.class);

    }

}
