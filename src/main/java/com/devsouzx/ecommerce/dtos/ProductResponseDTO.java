package com.devsouzx.ecommerce.dtos;

import com.devsouzx.ecommerce.domain.product.Product;
import com.devsouzx.ecommerce.services.BrandService;
import com.devsouzx.ecommerce.services.CategoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, String description, BigDecimal price, Integer stockQuantity, LocalDateTime createdAt, String category, String brand) {
    public ProductResponseDTO(Product product, CategoryService categoryService, BrandService brandService) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStockQuantity(), product.getCreatedAt(), categoryService.findById(product.getCategoryId()).getName(), brandService.findById(product.getBrandId()).getName());
    }
}
