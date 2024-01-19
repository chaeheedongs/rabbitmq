package com.study.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.rabbitmq.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RabbitJsonMockTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void init() {
        System.out.println("hello RabbitMQ Json Mock Test");
    }

    @Test
    void PublishAndConsumeTest() throws Exception {

        User user = new User(1, "hello", "RabbitMQ");

        String body = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/api/v1/json/publish")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
