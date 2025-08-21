package com.example.microservicedelivery.service;

import com.example.microservicedelivery.entities.Delivery;
import com.example.microservicedelivery.entities.DeliveryStatus;
import com.example.microservicedelivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery assignDelivery(Delivery delivery) {
        delivery.setDeliveryStatus(DeliveryStatus.ASSIGNED);
        return deliveryRepository.save(delivery);
    }

    public Optional<Delivery> getDeliveryByOrderId(Long orderId) {
        return deliveryRepository.findByOrderId(orderId);
    }

    public Delivery updateDeliveryStatus(Long id, DeliveryStatus status) {
        Optional<Delivery> deliveryOpt = deliveryRepository.findById(id);
        if (deliveryOpt.isEmpty()) {
            throw new RuntimeException("Delivery not found with ID: " + id);
        }
        Delivery delivery = deliveryOpt.get();
        delivery.setDeliveryStatus(status);
        return deliveryRepository.save(delivery);
    }
}
