package com.devsouzx.ecommerce.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequestDTO(String name, String description, BigDecimal price, Integer stockQuantity, UUID categoryId) {
}