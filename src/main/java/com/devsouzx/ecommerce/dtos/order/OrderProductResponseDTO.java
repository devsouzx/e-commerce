package com.devsouzx.ecommerce.dtos.order;

import com.devsouzx.ecommerce.dtos.product.ProductResponseDTO;

import java.math.BigDecimal;

public record OrderProductResponseDTO(ProductResponseDTO product, Integer quantity, BigDecimal subTotal) {
}
