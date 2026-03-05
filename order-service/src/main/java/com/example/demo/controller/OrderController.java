package com.example.demo.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public String getOrders() {
        return "Order Service is running! Use POST /orders to create an order.";
    }

    @PostMapping
    public String createOrder(@RequestBody String order) {
        kafkaTemplate.send("order-topic", order);
        return "Order Created & Event Published";
    }
}