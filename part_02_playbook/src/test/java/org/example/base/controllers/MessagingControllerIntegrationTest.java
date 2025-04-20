package org.example.base.controllers;

import jakarta.jms.JMSException;
import org.example.base.jms.SampleListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MessagingControllerIntegrationTest {

    @MockitoSpyBean
    private SampleListener sampleListener;

    @Autowired
    private MessagingController messagingController;

    @Test
    void test_sendJms() throws JMSException, InterruptedException {
        String result = messagingController.sendJmsMessage();
        String expected = "done";
        assertEquals(expected, result);
        verify(sampleListener, timeout(100).times(1)).receiveMessage(any());
    }

}