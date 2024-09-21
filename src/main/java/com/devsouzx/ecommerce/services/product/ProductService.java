package com.devsouzx.ecommerce.services.product;

import com.devsouzx.ecommerce.domain.product.Product;
import com.devsouzx.ecommerce.dtos.product.ProductRequestDTO;
import com.devsouzx.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findProductsByCategoryId(UUID id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public List<Product> findProductsByBrandId(UUID id) {
        return productRepository.findByBrandId(id);
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product update(UUID id, ProductRequestDTO body) {
        Product product = this.findById(id);
        this.updateDate(product, body);
        return productRepository.save(product);
    }

    private void updateDate(Product product, ProductRequestDTO body) {
        product.setName(body.name());
        product.setDescription(body.description());
        product.setPrice(body.price());
        product.setStockQuantity(body.stockQuantity());
        product.setCategoryId(body.categoryId());
        product.setBrandId(body.brandId());
    }
}
