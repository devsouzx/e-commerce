package com.devsouzx.ecommerce.repositories;

import com.devsouzx.ecommerce.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    @Query("SELECT a FROM Address a " +
            "WHERE lower(a.city) = lower(:city) " +
            "AND lower(a.state) = lower(:state) " +
            "AND lower(a.street) = lower(:street) " +
            "AND a.number = :number ")
    Optional<Address> findByCityAndStateAndStreetAndNumber(
            @Param("city") String city,
            @Param("state") String state,
            @Param("street") String street,
            @Param("number") Integer number);
}
