package com.devsouzx.ecommerce.services.brand;

import com.devsouzx.ecommerce.domain.brand.Brand;
import com.devsouzx.ecommerce.domain.product.Product;
import com.devsouzx.ecommerce.dtos.brand.BrandRequestDTO;
import com.devsouzx.ecommerce.repositories.BrandRepository;
import com.devsouzx.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(UUID id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found!"));
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delete(Brand brand) {
        if (brand != null) {
            List<Product> products = productRepository.findByBrandId(brand.getId());

            for (Product product : products) {
                productRepository.delete(product);
            }
        }
        assert brand != null;
        brandRepository.delete(brand);
    }

    @Override
    public Brand update(UUID id, BrandRequestDTO body) {
        Brand brand = this.findById(id);
        brand.setName(body.name());
        brand.setDescription(body.description());
        brandRepository.save(brand);
        return brand;
    }
}
