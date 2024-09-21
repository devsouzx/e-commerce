package com.devsouzx.ecommerce.services.brand;

import com.devsouzx.ecommerce.domain.brand.Brand;
import com.devsouzx.ecommerce.dtos.brand.BrandRequestDTO;

import java.util.List;
import java.util.UUID;

public interface IBrandService {
    List<Brand> findAll();
    Brand findById(UUID id);
    void save(Brand brand);
    void delete(Brand brand);
    Brand update(UUID id, BrandRequestDTO body);
}
