package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.domain.address.Address;
import com.devsouzx.ecommerce.dtos.AddressRequestDTO;
import com.devsouzx.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(AddressRequestDTO body) {
        Address address = new Address();
        address.setCity(body.city());
        address.setState(body.state());
        address.setCountry(body.country());
        address.setStreet(body.street());
        address.setNumber(body.number());
        address.setDistrict(body.district());
        address.setAdditional(body.additional());
        address.setZipCode(body.zipCode());
        return addressRepository.save(address);
    }

    public Address findById(UUID id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }

    public Address findEqualsOrCreate(AddressRequestDTO body) {
        return addressRepository.findByCityAndStateAndStreetAndNumber(body.city(), body.state(), body.street(), body.number()).orElseGet(() -> this.createAddress(body));
    }

    public Address update(UUID id, AddressRequestDTO address) {
        Address entity = this.findById(id);
        this.updateDate(entity, address);
        return addressRepository.save(entity);
    }

    private void updateDate(Address entity, AddressRequestDTO address) {
        entity.setCity(address.city());
        entity.setStreet(address.street());
        entity.setState(address.state());
        entity.setCountry(address.country());
        entity.setNumber(address.number());
        entity.setZipCode(address.zipCode());
        entity.setAdditional(address.additional());
        entity.setDistrict(address.district());
    }
}
