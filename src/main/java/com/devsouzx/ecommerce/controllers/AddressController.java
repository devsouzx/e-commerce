package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.model.Address;
import com.devsouzx.ecommerce.model.UserAddress;
import com.devsouzx.ecommerce.requests.AddressRequestDTO;
import com.devsouzx.ecommerce.responses.AddressResponseDTO;
import com.devsouzx.ecommerce.model.User;
import com.devsouzx.ecommerce.services.address.IAddressService;
import com.devsouzx.ecommerce.services.user.IUserAddressService;
import com.devsouzx.ecommerce.services.user.IUserService;
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
    private IAddressService addressService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserAddressService userAddressService;

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> getAddressById(@PathVariable UUID id) {
        Address address = addressService.findById(id);
        return ResponseEntity.ok(new AddressResponseDTO(address));
    }

    @PostMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> addAddress(@PathVariable UUID id, @RequestBody AddressRequestDTO body) {
        User user = userService.findById(id);
        Address address = addressService.findEqualsOrCreate(body);
        UserAddress userAddress = new UserAddress(user, address);
        userAddressService.saveUserAddress(userAddress);
        return ResponseEntity.ok(new AddressResponseDTO(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> updateAddress(@PathVariable UUID id, @RequestBody AddressRequestDTO body) {
        Address address = addressService.update(id, body);
        return ResponseEntity.ok(new AddressResponseDTO(address));
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
