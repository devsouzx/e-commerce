package com.devsouzx.ecommerce.domain.user.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String phone, String role, Date birthDate, String gender, LocalDateTime createdAt) {
}
