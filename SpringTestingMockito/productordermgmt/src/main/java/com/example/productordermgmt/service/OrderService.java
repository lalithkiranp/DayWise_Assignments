package com.example.productordermgmt.service;

import com.example.productordermgmt.entity.Order;
import com.example.productordermgmt.entity.Product;
import com.example.productordermgmt.repository.OrderRepository;
import com.example.productordermgmt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(Long productId, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found with ID: " + productId);
        }

        Product product = optionalProduct.get();

        if (product.getAvailableQuantity() < quantity) {
            throw new RuntimeException("Not enough stock for product: " + product.getName());
        }

        // Reduce stock
        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
        productRepository.save(product);

        // Create order
        Order order = new Order(product, LocalDate.now(), quantity);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
