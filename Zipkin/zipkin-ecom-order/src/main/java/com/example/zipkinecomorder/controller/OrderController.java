package com.example.zipkinecomorder.controller;

import io.micrometer.tracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate;
    private final Tracer tracer;

    @Autowired
    public OrderController(RestTemplate restTemplate, Tracer tracer) {
        this.restTemplate = restTemplate;
        this.tracer = tracer;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Map<String, Object> order) {
        String traceId = tracer.currentSpan() != null ? tracer.currentSpan().context().traceId() : "no-trace";
        System.out.println("Order Service: received order=" + order + " traceId=" + traceId);

        // Call Payment service (trace headers propagate because RestTemplate was built by RestTemplateBuilder)
        String paymentResponse = restTemplate.postForObject(
                "http://localhost:8082/payment",
                order,
                String.class
        );

        return ResponseEntity.ok("Order placed. Payment response: " + paymentResponse + " (traceId=" + traceId + ")");
    }
}
