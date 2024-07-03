package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
