package com.devsouzx.ecommerce.responses;

import com.devsouzx.ecommerce.model.Brand;

import java.util.UUID;

public record BrandResponseDTO(UUID id, String name, String description) {
    public BrandResponseDTO(Brand brand) {
        this(brand.getId(), brand.getName(), brand.getDescription());
    }
}
