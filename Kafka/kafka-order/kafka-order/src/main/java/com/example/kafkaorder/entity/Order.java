package com.example.kafkaorder.entity;



import java.time.LocalDate;

public class Order {
    private String orderId;
    private String customerName;
    private String productName;
    private int quantity;
    private double price;
    private LocalDate orderDate;

    public Order() {}

    public Order(String orderId, String customerName, String productName, int quantity, double price, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "\n orderId=" + orderId +
                "\n customerName=" + customerName +
                "\n productName=" + productName +
                "\n quantity=" + quantity +
                "\n price=" + price +
                "\n orderDate=" + orderDate + ")";
    }
}

