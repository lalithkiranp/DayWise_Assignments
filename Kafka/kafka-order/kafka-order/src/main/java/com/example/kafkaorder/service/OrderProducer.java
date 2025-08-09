package com.example.kafkaorder.service;
import com.example.kafkaorder.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    private static final String TOPIC_NAME = "order-topic";

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        LOGGER.info("Sending order to Kafka: {}", order);
        kafkaTemplate.send(TOPIC_NAME, order);
    }
}
