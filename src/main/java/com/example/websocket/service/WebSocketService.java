package com.example.websocket.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {


    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void sendSchduledMessage() {
        this.simpMessagingTemplate.convertAndSend("/queue/schedule", "Schduled Message");
    }
}
