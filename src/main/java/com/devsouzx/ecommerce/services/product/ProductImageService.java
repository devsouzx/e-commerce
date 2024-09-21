package com.devsouzx.ecommerce.services.product;

import com.devsouzx.ecommerce.model.ProductImage;
import com.devsouzx.ecommerce.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService implements IProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public void save(ProductImage productImage) {
        productImageRepository.save(productImage);
    }
}
