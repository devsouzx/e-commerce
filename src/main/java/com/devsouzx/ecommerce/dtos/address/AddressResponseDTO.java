package com.devsouzx.ecommerce.dtos.address;

import com.devsouzx.ecommerce.domain.address.Address;

import java.util.UUID;

public record AddressResponseDTO(UUID id,
                                 String city,
                                 String state,
                                 String country,
                                 String street,
                                 Integer number,
                                 String district,
                                 String additional,
                                 String zipCode) {
    public AddressResponseDTO(Address address) {
        this(address.getId(), address.getCity(), address.getState(), address.getCountry(), address.getStreet(), address.getNumber(), address.getDistrict(), address.getAdditional(), address.getZipCode());
    }
}
