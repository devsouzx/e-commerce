package com.devsouzx.ecommerce.dtos;

import com.devsouzx.ecommerce.domain.user.UserGender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserRequestDTO(String name, String email, String password, String phone, LocalDate birthDate, UserGender gender, String avatarUrl, LocalDateTime createdAt) {
}
