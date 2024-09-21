package com.devsouzx.ecommerce.requests;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(UUID userId, UUID addressId, List<OrderProductRequestDTO> items) {
}
