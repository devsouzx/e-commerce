package com.devsouzx.ecommerce.dtos.order;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(UUID userId, UUID addressId, List<OrderProductRequestDTO> items) {
}
