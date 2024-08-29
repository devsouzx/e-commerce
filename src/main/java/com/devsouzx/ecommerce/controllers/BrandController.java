package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.product.Brand;
import com.devsouzx.ecommerce.dtos.*;
import com.devsouzx.ecommerce.services.BrandService;
import com.devsouzx.ecommerce.services.CategoryService;
import com.devsouzx.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<BrandResponseDTO>> getAllBrands() {
        List<BrandResponseDTO> brands = brandService.findAll().stream().map(BrandResponseDTO::new).toList();
        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<BrandResponseDTO> createBrand(@RequestBody BrandRequestDTO body) {
        Brand brand = new Brand(body.name(), body.description());
        brandService.save(brand);
        return ResponseEntity.ok(new BrandResponseDTO(brand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponseDTO> getBrand(@PathVariable UUID id) {
        Brand brand = brandService.findById(id);
        return ResponseEntity.ok(new BrandResponseDTO(brand));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByBrand(@PathVariable UUID id) {
        Brand brand = brandService.findById(id);
        List<ProductResponseDTO> products = productService.findProductsByBrandId(brand.getId()).stream().map(product -> new ProductResponseDTO(product, categoryService, brandService)).toList();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable UUID id) {
        Brand brand = brandService.findById(id);
        if (brand == null) {
            return ResponseEntity.notFound().build();
        }
        brandService.delete(brand);
        return ResponseEntity.ok("Brand deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponseDTO> updateBrand(@PathVariable UUID id, @RequestBody BrandRequestDTO body) {
        Brand brand = brandService.update(id, body);
        return ResponseEntity.ok(new BrandResponseDTO(brand));
    }
}
