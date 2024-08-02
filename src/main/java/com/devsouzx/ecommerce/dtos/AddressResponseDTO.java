package com.devsouzx.ecommerce.dtos;

import com.devsouzx.ecommerce.domain.address.Address;
import com.devsouzx.ecommerce.domain.address.UserAddress;
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
    public AddressResponseDTO(Address address) {
        this(address.getId(), address.getCity(), address.getState(), address.getCountry(), address.getStreet(), address.getNumber(), address.getDistrict(), address.getAdditional(), address.getZipCode(), address.getUsers());
    }
}
