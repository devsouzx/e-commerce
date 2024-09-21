package com.devsouzx.ecommerce.services.user;

import com.devsouzx.ecommerce.domain.address.UserAddress;

public interface IUserAddressService {
    UserAddress saveUserAddress(UserAddress userAddress);
}
