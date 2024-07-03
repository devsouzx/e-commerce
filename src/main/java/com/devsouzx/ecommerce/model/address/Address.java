package com.devsouzx.ecommerce.model.address;

import com.devsouzx.ecommerce.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

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
    private String street;
    private Integer number;
    private String district;
    private String additional;
    private Long code;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<User> users;
}
