package com.devsouzx.ecommerce.services;

import com.devsouzx.ecommerce.domain.address.UserAddress;
import com.devsouzx.ecommerce.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {
    @Autowired
    private UserAddressRepository userAddressRepository;

    public void saveUserAddress(UserAddress userAddress) {
        userAddressRepository.save(userAddress);
    }
}
