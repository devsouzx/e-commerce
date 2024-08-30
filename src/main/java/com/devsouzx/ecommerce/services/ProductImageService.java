package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.domain.product.ProductImage;
import com.devsouzx.ecommerce.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    public void save(ProductImage productImage) {
        productImageRepository.save(productImage);
    }
}
