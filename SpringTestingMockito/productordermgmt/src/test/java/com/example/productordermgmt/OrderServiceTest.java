package com.example.productordermgmt;


import com.example.productordermgmt.entity.Order;
import com.example.productordermgmt.entity.Product;
import com.example.productordermgmt.repository.OrderRepository;
import com.example.productordermgmt.repository.ProductRepository;
import com.example.productordermgmt.service.OrderService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderService orderService;

    private Product sampleProduct;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        sampleProduct = new Product("Phone", 30000.0, 5);
        sampleProduct.setProductId(10L);
    }

    @Test
    void testPlaceOrder_Success() {
        when(productRepository.findById(10L)).thenReturn(Optional.of(sampleProduct));
        when(productRepository.save(any(Product.class))).thenReturn(sampleProduct);
        when(orderRepository.save(any(Order.class))).thenAnswer(i -> i.getArgument(0));

        Order order = orderService.placeOrder(10L, 3);

        assertNotNull(order);
        assertEquals(3, order.getQuantityOrdered());
        assertEquals(2, sampleProduct.getAvailableQuantity());

        verify(orderRepository).save(any(Order.class));
        verify(productRepository).save(sampleProduct);
    }

    @Test
    void testPlaceOrder_InsufficientStock() {
        when(productRepository.findById(10L)).thenReturn(Optional.of(sampleProduct));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            orderService.placeOrder(10L, 10);
        });

        assertEquals("Not enough stock for product: Phone", ex.getMessage());
    }

    @Test
    void testPlaceOrder_ProductNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            orderService.placeOrder(99L, 1);
        });

        assertEquals("Product not found with ID: 99", ex.getMessage());
    }
}
