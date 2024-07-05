package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.model.address.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAddressRepository extends JpaRepository<UserAddress, UUID> {
}
