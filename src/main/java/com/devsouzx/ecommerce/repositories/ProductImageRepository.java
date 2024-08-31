package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.product.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImage, UUID> {
}