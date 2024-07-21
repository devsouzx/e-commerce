package com.devsouzx.ecommerce.domain.user.dto;

import com.devsouzx.ecommerce.domain.user.UserGender;

import java.time.LocalDateTime;
import java.util.Date;

public record UserRequestDTO(String name, String email, String password, String phone, Date birthDate, UserGender gender, LocalDateTime createdAt) {
}
