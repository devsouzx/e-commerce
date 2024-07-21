package com.devsouzx.ecommerce.model.address;

import com.devsouzx.ecommerce.model.pk.UserAddressPK;
import com.devsouzx.ecommerce.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Table(name = "address")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String city;
    private String state;
    private String country;
    private String street;
    private Integer number;
    private String district;
    private String additional;
    private String zipCode;

    @OneToMany(mappedBy = "id.address", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserAddress> userAddresses = new HashSet<>();

    public Set<User> getUsers() {
        return userAddresses.stream()
                .map(UserAddress::getId)
                .map(UserAddressPK::getUser)
                .collect(Collectors.toSet());
    }
}