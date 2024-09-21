package com.devsouzx.ecommerce.responses;

import com.devsouzx.ecommerce.model.User;
import com.devsouzx.ecommerce.model.UserGender;
import com.devsouzx.ecommerce.model.UserRole;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String phone, UserRole role, LocalDate birthDate, UserGender gender, LocalDateTime createdAt, String avatarUrl, List<AddressResponseDTO> addresses) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getRole(), user.getBirthDate(), user.getGender(), user.getCreatedAt(), user.getAvatarUrl(), user.getAddresses().stream().map(AddressResponseDTO::new).toList());
    }
}
