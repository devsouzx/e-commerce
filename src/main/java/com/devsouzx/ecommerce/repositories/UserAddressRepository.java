package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.address.UserAddress;
import com.devsouzx.ecommerce.domain.pk.UserAddressPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, UserAddressPK> {
}
