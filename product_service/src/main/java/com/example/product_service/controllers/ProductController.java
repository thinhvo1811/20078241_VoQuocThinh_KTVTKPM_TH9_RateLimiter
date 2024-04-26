package com.example.product_service.controllers;

import com.example.product_service.models.Product;
import com.example.product_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product-service/read")
    public List<Product> getAllProducts() {
        System.out.println("Call api");
//        // Giả lập một tình huống khi gặp lỗi
//        if (true) {
//            throw new RuntimeException("Failed to fetch products");
//        }
        return productRepository.findAll();
    }

    @PostMapping("/product-service/create")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
