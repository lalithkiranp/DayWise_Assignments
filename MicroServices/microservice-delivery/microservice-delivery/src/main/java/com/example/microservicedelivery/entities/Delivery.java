package com.example.microservicedelivery.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private String deliveryPersonName;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    // Constructors
    public Delivery() {}

    public Delivery(Long orderId, String deliveryPersonName, DeliveryStatus deliveryStatus) {
        this.orderId = orderId;
        this.deliveryPersonName = deliveryPersonName;
        this.deliveryStatus = deliveryStatus;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public String getDeliveryPersonName() { return deliveryPersonName; }
    public void setDeliveryPersonName(String deliveryPersonName) { this.deliveryPersonName = deliveryPersonName; }

    public DeliveryStatus getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) { this.deliveryStatus = deliveryStatus; }
}
