package com.study.rabbitmq.controller;

import com.study.rabbitmq.dto.User;
import com.study.rabbitmq.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/json")
@RequiredArgsConstructor
public class MessageJsonController {

    private final RabbitMQJsonProducer producer;

    // # POST /api/json/v1/publish
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {

        log.info("### >> [rabbit] Request Json -> {}", user);
        producer.publishJson(user);

        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
