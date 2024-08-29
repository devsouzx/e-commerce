package com.devsouzx.ecommerce.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "product")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private LocalDateTime createdAt;
    private UUID categoryId;
    private UUID brandId;

    public Product(String name, String description, BigDecimal price, Integer stockQuantity, UUID categoryId, UUID brandId, LocalDateTime createdAt) {
        this.stockQuantity = stockQuantity;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.createdAt = createdAt;
        this.price = price;
        this.name = name;
        this.description = description;
    }
}
