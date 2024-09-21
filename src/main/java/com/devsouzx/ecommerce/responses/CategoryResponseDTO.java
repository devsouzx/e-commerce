package com.devsouzx.ecommerce.responses;

import com.devsouzx.ecommerce.model.Category;

import java.util.UUID;

public record CategoryResponseDTO(UUID id, String name, String description) {
    public CategoryResponseDTO(Category category) {
        this(category.getId(), category.getName(), category.getDescription());
    }
}
