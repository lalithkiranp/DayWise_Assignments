package com.example.microserviceorder.service;

import com.example.microserviceorder.entity.Order;
import com.example.microserviceorder.entity.OrderItem;
import com.example.microserviceorder.entity.OrderStatus;
import com.example.microserviceorder.repository.OrderRepository;
import com.example.microserviceorder.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.restTemplate = restTemplate;
    }

    public Order placeOrder(Order order) {
        double total = 0.0;

        for (OrderItem item : order.getItems()) {
            String url = "http://localhost:8081/api/menu/" + item.getMenuItemId();
            ResponseEntity<Double> priceResponse = restTemplate.getForEntity(url, Double.class);

            if (!priceResponse.getStatusCode().is2xxSuccessful() || priceResponse.getBody() == null) {
                throw new RuntimeException("Menu item not found: ID = " + item.getMenuItemId());
            }

            double price = priceResponse.getBody();
            item.setPrice(price);
            item.setOrder(order);

            total += price * item.getQuantity();
        }

        order.setTotalAmount(total);
        order.setStatus(OrderStatus.PLACED);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByCustomer(String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }

    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        return orderRepository.save(order);
    }
}
