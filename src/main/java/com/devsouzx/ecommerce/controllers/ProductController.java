package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.product.Product;
import com.devsouzx.ecommerce.domain.product.ProductImage;
import com.devsouzx.ecommerce.dtos.product.ImageRequestDTO;
import com.devsouzx.ecommerce.dtos.product.ProductRequestDTO;
import com.devsouzx.ecommerce.dtos.product.ProductResponseDTO;
import com.devsouzx.ecommerce.services.brand.IBrandService;
import com.devsouzx.ecommerce.services.category.ICategoryService;
import com.devsouzx.ecommerce.services.product.IProductImageService;
import com.devsouzx.ecommerce.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductImageService productImageService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        List<ProductResponseDTO> products = productService.findAll().stream().map(product -> new ProductResponseDTO(product, categoryService, brandService)).toList();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO body) {
        Product product = new Product(body.name(), body.description(), body.price(), body.stockQuantity(), body.categoryId(), body.brandId(), LocalDateTime.now());
        productService.save(product);
        return ResponseEntity.ok(new ProductResponseDTO(product, categoryService, brandService));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(new ProductResponseDTO(product, categoryService, brandService));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        Product product = productService.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productService.delete(product);
        return ResponseEntity.ok("Product deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID id, @RequestBody ProductRequestDTO body) {
        Product product = productService.update(id, body);
        return ResponseEntity.ok(new ProductResponseDTO(product, categoryService, brandService));
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<?> addImageToProduct(@PathVariable UUID id, @RequestBody ImageRequestDTO image) {
        Product product = productService.findById(id);
        ProductImage productImage = new ProductImage(product, image.imageUrl());
        productImageService.save(productImage);
        return ResponseEntity.ok(new ProductResponseDTO(product, categoryService, brandService));
    }
}
