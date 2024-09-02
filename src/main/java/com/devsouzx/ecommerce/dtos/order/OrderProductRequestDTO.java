package com.devsouzx.ecommerce.dtos.order;

import java.util.UUID;

public record OrderProductRequestDTO(UUID productId, Integer quantity) {
}
