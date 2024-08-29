package com.devsouzx.ecommerce.dtos;

import com.devsouzx.ecommerce.domain.product.Category;
import com.devsouzx.ecommerce.domain.product.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, String description, BigDecimal price, Integer stockQuantity, LocalDateTime createdAt, String category) {
    public ProductResponseDTO(Product product, Category category) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStockQuantity(), product.getCreatedAt(), category.getName());
    }
}
