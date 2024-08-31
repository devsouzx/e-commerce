package com.devsouzx.ecommerce.dtos.brand;

import com.devsouzx.ecommerce.domain.brand.Brand;

import java.util.UUID;

public record BrandResponseDTO(UUID id, String name, String description) {
    public BrandResponseDTO(Brand brand) {
        this(brand.getId(), brand.getName(), brand.getDescription());
    }
}
