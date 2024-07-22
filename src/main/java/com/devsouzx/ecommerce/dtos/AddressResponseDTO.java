package com.devsouzx.ecommerce.dtos;

import com.devsouzx.ecommerce.domain.user.User;

import java.util.Set;
import java.util.UUID;

public record AddressResponseDTO(UUID id,
                                 String city,
                                 String state,
                                 String country,
                                 String street,
                                 Integer number,
                                 String district,
                                 String additional,
                                 String zipCode,
                                 Set<User> users) {
}
