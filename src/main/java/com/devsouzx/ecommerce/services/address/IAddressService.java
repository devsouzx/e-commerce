package com.devsouzx.ecommerce.services.address;

import com.devsouzx.ecommerce.model.Address;
import com.devsouzx.ecommerce.model.User;
import com.devsouzx.ecommerce.requests.AddressRequestDTO;

import java.util.List;
import java.util.UUID;

public interface IAddressService {
    Address createAddress(AddressRequestDTO body);
    Address findById(UUID id);
    Address findEqualsOrCreate(AddressRequestDTO body);
    Address update(UUID id, AddressRequestDTO address);
    List<Address> findAddressesByUser(User user);
}
