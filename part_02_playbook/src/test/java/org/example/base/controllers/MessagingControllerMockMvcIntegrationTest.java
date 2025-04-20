package org.example.base.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
class MessagingControllerMockMvcIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test_sendJms() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/sendJmsMessage"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("done"));
    }

}