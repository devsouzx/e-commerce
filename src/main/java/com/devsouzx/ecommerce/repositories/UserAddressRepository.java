package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.domain.address.Address;
import com.devsouzx.ecommerce.domain.address.UserAddress;
import com.devsouzx.ecommerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserAddressRepository extends JpaRepository<UserAddress, UUID> {
    @Query("SELECT ua.address FROM UserAddress ua WHERE ua.user = :user")
    List<Address> findAddressesByUser(User user);
}
