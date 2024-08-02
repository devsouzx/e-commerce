package com.devsouzx.ecommerce.domain.address;

import com.devsouzx.ecommerce.domain.pk.UserAddressPK;
import com.devsouzx.ecommerce.domain.user.User;
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
