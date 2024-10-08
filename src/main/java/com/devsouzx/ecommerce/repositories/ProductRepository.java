package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByCategoryId(UUID categoryId);

    List<Product> findByBrandId(UUID brandId);
}
