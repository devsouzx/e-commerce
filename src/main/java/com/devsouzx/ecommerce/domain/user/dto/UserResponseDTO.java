package com.devsouzx.ecommerce.domain.user.dto;

import com.devsouzx.ecommerce.domain.user.User;
import com.devsouzx.ecommerce.domain.user.UserGender;
import com.devsouzx.ecommerce.domain.user.UserRole;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String phone, UserRole role, Date birthDate, UserGender gender, LocalDateTime createdAt) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getRole(), user.getBirthDate(), user.getGender(), user.getCreatedAt());
    }
}
