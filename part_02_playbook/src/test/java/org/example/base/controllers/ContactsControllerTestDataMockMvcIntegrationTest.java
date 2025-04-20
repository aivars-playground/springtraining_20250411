package org.example.base.controllers;

import org.example.base.config.DbTestPreloadConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {DbTestPreloadConfig.class})
@AutoConfigureMockMvc
class ContactsControllerTestDataMockMvcIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test_getAllUsers() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"TESTUSER\"")))
                .andExpect(content().string(not(containsString("\"Prod User\""))));
    }

}