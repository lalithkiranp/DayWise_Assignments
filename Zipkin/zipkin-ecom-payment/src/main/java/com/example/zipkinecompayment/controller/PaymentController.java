package com.example.zipkinecompayment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody Map<String, Object> payload) {
        System.out.println("Payment Service: processing payment for " + payload);
        // simulate processing
        try { Thread.sleep(800); } catch (InterruptedException ignored) {}
        System.out.println("Payment Service: done for " + payload);
        return ResponseEntity.ok("Payment successful");
    }
}
