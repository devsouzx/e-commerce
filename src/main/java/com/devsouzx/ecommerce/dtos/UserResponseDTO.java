package com.devsouzx.ecommerce.dtos;

import com.devsouzx.ecommerce.domain.address.Address;
import com.devsouzx.ecommerce.domain.user.User;
import com.devsouzx.ecommerce.domain.user.UserGender;
import com.devsouzx.ecommerce.domain.user.UserRole;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String phone, UserRole role, LocalDate birthDate, UserGender gender, LocalDateTime createdAt, String avatarUrl, List<Address> addresses) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getRole(), user.getBirthDate(), user.getGender(), user.getCreatedAt(), user.getAvatarUrl(), user.getAddresses());
    }
}
