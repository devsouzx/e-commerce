package com.devsouzx.ecommerce.services.address;

import com.devsouzx.ecommerce.domain.address.Address;
import com.devsouzx.ecommerce.domain.user.User;
import com.devsouzx.ecommerce.dtos.address.AddressRequestDTO;
import com.devsouzx.ecommerce.repositories.AddressRepository;
import com.devsouzx.ecommerce.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
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

    @Override
    public Address findById(UUID id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }

    @Override
    public Address findEqualsOrCreate(AddressRequestDTO body) {
        return addressRepository.findByCityAndStateAndStreetAndNumber(body.city(), body.state(), body.street(), body.number()).orElseGet(() -> this.createAddress(body));
    }

    @Override
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

    @Override
    public List<Address> findAddressesByUser(User user) {
        return userAddressRepository.findAddressesByUser(user);
    }
}
