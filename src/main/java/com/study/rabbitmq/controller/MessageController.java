package com.study.rabbitmq.controller;

import com.study.rabbitmq.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer producer;

    // GET http://localhost:8080/api/v1/publish?message=
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {

        log.info("### >> [rabbit] Request Message -> {}", message);
        producer.publish(message);

        return ResponseEntity.ok("Message Sent to RabbitMQ ...");
    }
}
