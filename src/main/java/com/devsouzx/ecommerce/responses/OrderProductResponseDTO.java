package com.devsouzx.ecommerce.responses;

import java.math.BigDecimal;

public record OrderProductResponseDTO(ProductResponseDTO product, Integer quantity, BigDecimal subTotal) {
}
