package com.devsouzx.ecommerce.services.category;

import com.devsouzx.ecommerce.model.Category;
import com.devsouzx.ecommerce.requests.CategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(UUID id);
    void save(Category category);
    Category findCategoryByName(String categoryName);
    void delete(Category category);
    Category update(UUID id, CategoryRequestDTO body);
}
