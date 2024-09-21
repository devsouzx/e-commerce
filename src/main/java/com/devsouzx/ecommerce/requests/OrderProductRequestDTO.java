package com.devsouzx.ecommerce.requests;

import java.util.UUID;

public record OrderProductRequestDTO(UUID productId, Integer quantity) {
}
