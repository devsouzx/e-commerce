package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}