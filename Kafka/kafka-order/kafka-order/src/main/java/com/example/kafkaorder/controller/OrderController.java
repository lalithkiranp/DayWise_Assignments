package com.example.kafkaorder.controller;


import com.example.kafkaorder.entity.Order;
import com.example.kafkaorder.service.OrderProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order sent to Kafka successfully");
    }
}
