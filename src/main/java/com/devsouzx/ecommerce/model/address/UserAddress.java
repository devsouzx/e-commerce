package com.devsouzx.ecommerce.model.address;

import com.devsouzx.ecommerce.model.pk.UserAddressPK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_address")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    @EmbeddedId
    private UserAddressPK id = new UserAddressPK();
}
