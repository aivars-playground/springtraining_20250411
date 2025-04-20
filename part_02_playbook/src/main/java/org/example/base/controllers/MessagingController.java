package org.example.base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/sendJmsMessage")
    String sendJmsMessage() {
        jmsTemplate.convertAndSend("DLQ", "Hello World");
        return "done";
    }

}
