package com.example.productordermgmt.repository;

import com.example.productordermgmt.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
   
}
