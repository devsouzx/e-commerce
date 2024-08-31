package com.devsouzx.ecommerce.dtos.product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequestDTO(String name, String description, BigDecimal price, Integer stockQuantity, UUID categoryId, UUID brandId) {
}
