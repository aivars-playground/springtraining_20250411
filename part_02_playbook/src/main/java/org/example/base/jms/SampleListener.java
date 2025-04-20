package org.example.base.jms;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class SampleListener {

    @JmsListener(destination = "DLQ")
    public void receiveMessage(Message message) throws JMSException {
        switch (message) {
            case TextMessage str -> {
                System.out.println("===========Received TextMessage:" + str.getText());
            }
            default -> throw new IllegalStateException("Unexpected message: " + message);
        };
    }

}
