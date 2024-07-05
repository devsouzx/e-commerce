package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.model.address.Address;
import com.devsouzx.ecommerce.model.address.dto.AddressRequestDTO;
import com.devsouzx.ecommerce.model.user.User;
import com.devsouzx.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public Boolean verifyPassword(User user, String password) {
        return Objects.equals(user.getPassword(), password);
    }

    public Address createAddress(AddressRequestDTO body) {
        Address address = new Address();
        address.setCity(body.city());
        address.setState(body.state());
        address.setStreet(body.street());
        address.setNumber(body.number());
        address.setDistrict(body.district());
        address.setAdditional(body.additional());
        address.setCode(body.code());
        return addressRepository.save(address);
    }
}
