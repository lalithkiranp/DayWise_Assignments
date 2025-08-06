package com.example.productordermgmt.repository;

import com.example.productordermgmt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
