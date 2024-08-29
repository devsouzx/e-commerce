package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.product.Category;
import com.devsouzx.ecommerce.dtos.CategoryRequestDTO;
import com.devsouzx.ecommerce.dtos.CategoryResponseDTO;
import com.devsouzx.ecommerce.dtos.ProductResponseDTO;
import com.devsouzx.ecommerce.services.BrandService;
import com.devsouzx.ecommerce.services.CategoryService;
import com.devsouzx.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

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

    @GetMapping("/{categoryName}")
    public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable String categoryName) {
        Category category = categoryService.findCategoryByName(categoryName);
        return ResponseEntity.ok(new CategoryResponseDTO(category));
    }

    @GetMapping("/{categoryName}/products")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable String categoryName) {
        Category category = categoryService.findCategoryByName(categoryName);
        List<ProductResponseDTO> products = productService.findProductsByCategoryId(category.getId()).stream().map(product -> new ProductResponseDTO(product, categoryService, brandService)).toList();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        categoryService.delete(category);
        return ResponseEntity.ok("Category deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable UUID id, @RequestBody CategoryRequestDTO body) {
        Category category = categoryService.update(id, body);
        return ResponseEntity.ok(new CategoryResponseDTO(category));
    }
}
