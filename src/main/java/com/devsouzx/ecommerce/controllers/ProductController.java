package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.product.Product;
import com.devsouzx.ecommerce.dtos.ProductRequestDTO;
import com.devsouzx.ecommerce.dtos.ProductResponseDTO;
import com.devsouzx.ecommerce.services.CategoryService;
import com.devsouzx.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        List<ProductResponseDTO> products = productService.findAll().stream().map(product -> new ProductResponseDTO(product, categoryService.findById(product.getCategoryId()))).toList();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO body) {
        Product product = new Product(body.name(), body.description(), body.price(), body.stockQuantity(), body.categoryId(), LocalDateTime.now());
        productService.save(product);
        return ResponseEntity.ok(new ProductResponseDTO(product, categoryService.findById(body.categoryId())));
    }
}