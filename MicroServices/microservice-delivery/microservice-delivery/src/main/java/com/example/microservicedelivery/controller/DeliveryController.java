package com.example.microservicedelivery.controller;

import com.example.microservicedelivery.entities.Delivery;
import com.example.microservicedelivery.entities.DeliveryStatus;
import com.example.microservicedelivery.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public ResponseEntity<Delivery> assignDelivery(@RequestBody Delivery delivery) {
        return ResponseEntity.ok(deliveryService.assignDelivery(delivery));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Delivery> getDeliveryByOrderId(@PathVariable Long orderId) {
        Optional<Delivery> deliveryOpt = deliveryService.getDeliveryByOrderId(orderId);
        return deliveryOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Delivery> updateDeliveryStatus(
            @PathVariable Long id,
            @RequestParam DeliveryStatus status) {
        return ResponseEntity.ok(deliveryService.updateDeliveryStatus(id, status));
    }
}
