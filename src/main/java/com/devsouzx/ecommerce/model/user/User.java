package com.devsouzx.ecommerce.model.user;

import com.devsouzx.ecommerce.model.address.UserAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
    private UserRole role;
    private Date birthDate;
    private UserGender gender;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserAddress> addresses = new HashSet<>();
}
