package com.devsouzx.ecommerce.model.user.dto;

import com.devsouzx.ecommerce.model.user.UserGender;
import com.devsouzx.ecommerce.model.user.UserRole;

import java.time.LocalDateTime;
import java.util.Date;

public record UserRequestDTO(String name, String email, String password, String phone, UserRole role, Date birthDate, UserGender gender, LocalDateTime createdAt) {
}
