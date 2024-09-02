package com.devsouzx.ecommerce.domain.order;

import com.devsouzx.ecommerce.domain.address.Address;
import com.devsouzx.ecommerce.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "order_tb")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime moment;
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderProduct> items = new ArrayList<>();

    public Order(User user, Address address) {
        this.moment = LocalDateTime.now();
        this.status = OrderStatus.WAITING_PAYMENT;
        this.user = user;
        this.address = address;
    }

    public BigDecimal getTotal() {
        BigDecimal sum = BigDecimal.ZERO;
        for (OrderProduct x : items) {
            sum = sum.add(x.getSubTotal());
        }
        return sum;
    }
}
