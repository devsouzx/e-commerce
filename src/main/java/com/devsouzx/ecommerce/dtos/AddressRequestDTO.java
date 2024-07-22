package com.devsouzx.ecommerce.dtos;

public record AddressRequestDTO(String city,
                                String state,
                                String country,
                                String street,
                                Integer number,
                                String district,
                                String additional,
                                String zipCode) {
}
