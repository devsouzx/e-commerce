package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.domain.product.Product;
import com.devsouzx.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findProductsByCategoryId(UUID id) {
        return productRepository.findByCategoryId(id);
    }
}
