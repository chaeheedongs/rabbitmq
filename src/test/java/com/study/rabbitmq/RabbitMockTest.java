package com.study.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RabbitMockTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void init() {
        System.out.println("hello RabbitMQ Mock Test");
    }

    @Test
    void PublishAndConsumeTest() throws Exception {

        mockMvc.perform(get("/api/v1/publish")
                                .param("message", "hello RabbitMQ"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
