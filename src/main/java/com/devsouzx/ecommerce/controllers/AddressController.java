package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.model.address.Address;
import com.devsouzx.ecommerce.model.address.UserAddress;
import com.devsouzx.ecommerce.model.address.dto.AddressRequestDTO;
import com.devsouzx.ecommerce.model.address.dto.AddressResponseDTO;
import com.devsouzx.ecommerce.model.pk.UserAddressPK;
import com.devsouzx.ecommerce.model.user.User;
import com.devsouzx.ecommerce.repositories.AddressRepository;
import com.devsouzx.ecommerce.repositories.UserAddressRepository;
import com.devsouzx.ecommerce.repositories.UserRepository;
import com.devsouzx.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable UUID id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));

        AddressResponseDTO addressDTO = new AddressResponseDTO(address.getId(), address.getCity(), address.getState(), address.getStreet(), address.getNumber(), address.getDistrict(), address.getAdditional(), address.getCode(), address.getUsers());

        return ResponseEntity.ok(addressDTO);
    }

    @PostMapping("/{id}/{password}")
    public ResponseEntity<Address> addAddress(@PathVariable UUID id, @PathVariable String password, @RequestBody AddressRequestDTO body) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (addressService.verifyPassword(user, password)) {
            Address address = addressRepository.findByCityAndStateAndStreetAndNumber(body.city(), body.state(), body.street(), body.number()).orElseGet(() -> addressService.createAddress(body));

            UserAddress userAddress = new UserAddress(new UserAddressPK(user, address));
            userAddressRepository.save(userAddress);

            return ResponseEntity.ok(address);
        }
        return ResponseEntity.badRequest().build();
    }
}
