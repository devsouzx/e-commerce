package com.devsouzx.ecommerce.model.address.dto;

public record AddressRequestDTO(String city,
                                String state,
                                String country,
                                String street,
                                Integer number,
                                String district,
                                String additional,
                                String zipCode) {
}
