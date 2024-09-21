package com.devsouzx.ecommerce.services.product;

import com.devsouzx.ecommerce.model.Product;
import com.devsouzx.ecommerce.requests.ProductRequestDTO;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    List<Product> findProductsByCategoryId(UUID id);
    List<Product> findProductsByBrandId(UUID id);
    Product findById(UUID id);
    void delete(Product product);
    Product update(UUID id, ProductRequestDTO body);
}
