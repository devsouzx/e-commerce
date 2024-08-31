package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.domain.category.Category;
import com.devsouzx.ecommerce.domain.product.Product;
import com.devsouzx.ecommerce.dtos.category.CategoryRequestDTO;
import com.devsouzx.ecommerce.repositories.CategoryRepository;
import com.devsouzx.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    public void delete(Category category) {
        if (category != null) {
            List<Product> products = productRepository.findByCategoryId(category.getId());

            for (Product product : products) {
                productRepository.delete(product);
            }
        }
        assert category != null;
        categoryRepository.delete(category);
    }

    public Category update(UUID id, CategoryRequestDTO body) {
        Category category = this.findById(id);
        category.setName(body.name());
        category.setDescription(body.description());
        categoryRepository.save(category);
        return category;
    }
}
