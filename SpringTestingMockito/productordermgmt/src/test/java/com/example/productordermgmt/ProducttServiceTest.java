package com.example.productordermgmt;



import com.example.productordermgmt.entity.Product;
import com.example.productordermgmt.repository.ProductRepository;
import com.example.productordermgmt.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product sampleProduct;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        sampleProduct = new Product("Laptop", 50000.0, 10);
        sampleProduct.setProductId(1L);
    }

    @Test
    void testAddProduct() {
        when(productRepository.save(sampleProduct)).thenReturn(sampleProduct);

        Product saved = productService.addProduct(sampleProduct);

        assertNotNull(saved);
        assertEquals("Laptop", saved.getName());
        verify(productRepository, times(1)).save(sampleProduct);
    }

    @Test
    void testGetAllProducts() {
        List<Product> productList = Arrays.asList(sampleProduct);
        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();

        assertEquals(1, result.size());
        verify(productRepository).findAll();
    }

    @Test
    void testUpdateStock_Success() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));
        when(productRepository.save(any(Product.class))).thenAnswer(i -> i.getArgument(0));

        Product updated = productService.updateStock(1L, 20);

        assertEquals(20, updated.getAvailableQuantity());
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void testUpdateStock_ProductNotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            productService.updateStock(1L, 5);
        });

        assertEquals("Product not found with ID: 1", ex.getMessage());
    }
}
