package com.example.productordermgmt.service;

import com.example.productordermgmt.entity.Product;
import com.example.productordermgmt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateStock(Long productId, int qty) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setAvailableQuantity(qty);
            return productRepository.save(product);
        }
        throw new RuntimeException("Product not found with ID: " + productId);
    }
}
