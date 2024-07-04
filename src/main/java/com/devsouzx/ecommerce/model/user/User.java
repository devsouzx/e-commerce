package com.devsouzx.ecommerce.model.user;

import com.devsouzx.ecommerce.model.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;
}
