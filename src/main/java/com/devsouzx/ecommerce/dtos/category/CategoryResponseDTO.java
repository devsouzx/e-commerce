package com.devsouzx.ecommerce.dtos.category;

import com.devsouzx.ecommerce.domain.category.Category;

import java.util.UUID;

public record CategoryResponseDTO(UUID id, String name, String description) {
    public CategoryResponseDTO(Category category) {
        this(category.getId(), category.getName(), category.getDescription());
    }
}
