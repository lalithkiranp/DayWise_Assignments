package com.example.kafkaorder.service;

import com.example.kafkaorder.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "order-topic", groupId = "order-processing-group")
    public void consumeOrder(Order order) {
        LOGGER.info("\nReceived Order: {}", order);
    }
}
