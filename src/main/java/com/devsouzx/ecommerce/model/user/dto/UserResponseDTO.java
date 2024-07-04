package com.devsouzx.ecommerce.model.user.dto;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String phone) {
}
