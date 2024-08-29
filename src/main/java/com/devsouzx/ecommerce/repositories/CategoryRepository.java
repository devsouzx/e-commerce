package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
