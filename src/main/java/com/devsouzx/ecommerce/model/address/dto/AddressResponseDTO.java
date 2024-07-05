package com.devsouzx.ecommerce.model.address.dto;

import com.devsouzx.ecommerce.model.user.User;

import java.util.Set;
import java.util.UUID;

public record AddressResponseDTO(UUID id,
                                 String city,
                                 String state,
                                 String street,
                                 Integer number,
                                 String district,
                                 String additional,
                                 Long code,
                                 Set<User> users) {
}
