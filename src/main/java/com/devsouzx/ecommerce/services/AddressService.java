package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.model.address.Address;
import com.devsouzx.ecommerce.model.address.dto.AddressRequestDTO;
import com.devsouzx.ecommerce.model.address.dto.AddressResponseDTO;
import com.devsouzx.ecommerce.model.user.User;
import com.devsouzx.ecommerce.model.user.dto.UserRequestDTO;
import com.devsouzx.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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
        entity.setNumber(address.number());
        entity.setCode(address.code());
        entity.setAdditional(address.additional());
        entity.setDistrict(address.district());
    }
}
