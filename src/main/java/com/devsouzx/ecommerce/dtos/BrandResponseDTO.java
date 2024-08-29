package com.devsouzx.ecommerce.dtos;

import com.devsouzx.ecommerce.domain.product.Brand;

import java.util.UUID;

public record BrandResponseDTO(UUID id, String name, String description) {
    public BrandResponseDTO(Brand brand) {
        this(brand.getId(), brand.getName(), brand.getDescription());
    }
}
