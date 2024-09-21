package com.devsouzx.ecommerce.requests;

import com.devsouzx.ecommerce.model.UserGender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserRequestDTO(String name, String email, String password, String phone, LocalDate birthDate, UserGender gender, String avatarUrl, LocalDateTime createdAt) {
}
