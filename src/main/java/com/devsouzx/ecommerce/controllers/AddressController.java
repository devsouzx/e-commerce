package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.address.Address;
import com.devsouzx.ecommerce.domain.address.UserAddress;
import com.devsouzx.ecommerce.dtos.AddressRequestDTO;
import com.devsouzx.ecommerce.dtos.AddressResponseDTO;
import com.devsouzx.ecommerce.domain.user.User;
import com.devsouzx.ecommerce.services.AddressService;
import com.devsouzx.ecommerce.services.UserAddressService;
import com.devsouzx.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class  AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable UUID id) {
        Address address = addressService.findById(id);

        AddressResponseDTO addressDTO = new AddressResponseDTO(address);

        return ResponseEntity.ok(addressDTO);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Address> addAddress(@PathVariable UUID id, @RequestBody AddressRequestDTO body) {
        User user = userService.findById(id);
        Address address = addressService.findEqualsOrCreate(body);
        UserAddress userAddress = new UserAddress(user, address);
        userAddressService.saveUserAddress(userAddress);
        return ResponseEntity.ok(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable UUID id, @RequestBody AddressRequestDTO body) {
        Address address = addressService.update(id, body);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<AddressResponseDTO>> getAddressesByUserId(@PathVariable UUID id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<AddressResponseDTO> addressDTOs = user.getAddresses().stream()
                .map(AddressResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(addressDTOs);
    }
}
