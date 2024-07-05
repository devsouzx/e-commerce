package com.devsouzx.ecommerce.model.address.dto;

public record AddressRequestDTO(String city,
                                String state,
                                String street,
                                Integer number,
                                String district,
                                String additional,
                                Long code) {
}
