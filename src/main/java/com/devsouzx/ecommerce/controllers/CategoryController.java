package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.category.Category;
import com.devsouzx.ecommerce.dtos.category.CategoryRequestDTO;
import com.devsouzx.ecommerce.dtos.category.CategoryResponseDTO;
import com.devsouzx.ecommerce.dtos.product.ProductResponseDTO;
import com.devsouzx.ecommerce.services.brand.IBrandService;
import com.devsouzx.ecommerce.services.category.ICategoryService;
import com.devsouzx.ecommerce.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IBrandService brandService;

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

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategory(@PathVariable UUID id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(new CategoryResponseDTO(category));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable UUID id) {
        Category category = categoryService.findById(id);
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
