package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
    Brand findByName(String brandName);
}
