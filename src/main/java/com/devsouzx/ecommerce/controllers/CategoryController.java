package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.product.Category;
import com.devsouzx.ecommerce.dtos.CategoryRequestDTO;
import com.devsouzx.ecommerce.dtos.CategoryResponseDTO;
import com.devsouzx.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getCategories() {
        List<CategoryResponseDTO> categories = categoryService.findAll().stream().map(CategoryResponseDTO::new).toList();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO body) {
        Category category = new Category(body.name(), body.description());
        categoryService.save(category);
        return ResponseEntity.ok(new CategoryResponseDTO(category));
    }
}
